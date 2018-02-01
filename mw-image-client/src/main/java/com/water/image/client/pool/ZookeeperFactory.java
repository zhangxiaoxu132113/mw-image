package com.water.image.client.pool;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.Closeable;

/**
 * zookeeper工厂类，创建zookeeper连接对象
 * Created by ZMJ on 2018/2/1.
 */
@Getter
public class ZookeeperFactory implements FactoryBean<CuratorFramework>, Closeable, InitializingBean {
    private static Logger LOGGER = LoggerFactory.getLogger(ZookeeperFactory.class);

    /**
     * zookeeper集群地址
     */
    private String zookeeperHosts;

    // session超时
    private int sessionTimeout = 3000;
    private int connectionTimeout = 3000;

    private CuratorFramework zkClient;

    // 第三方未提供，所以暂时用不到
    private String namespace;

    @Override
    public CuratorFramework getObject() throws Exception {
        return this.zkClient;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isBlank(this.zookeeperHosts)) {
            return;
        }
        this.zkClient = this.create(zookeeperHosts, sessionTimeout, connectionTimeout, namespace);
        this.zkClient.start();
    }

    private CuratorFramework create(String connectString, int sessionTimeout, int connectionTimeout, String namespace) {
        try {
            CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
            return builder.connectString(connectString).sessionTimeoutMs(sessionTimeout).connectionTimeoutMs(connectionTimeout)
                    .canBeReadOnly(true).namespace(namespace)
                    .retryPolicy(new ExponentialBackoffRetry(1000, Integer.MAX_VALUE)).defaultData(null).build();
        } catch (Exception e) {
            LOGGER.error("ZookeeperFactory create error", e);
            throw e;
        }
    }

    public void close() {
        if (zkClient != null) {
            zkClient.close();
        }
    }

    @Override
    public Class<?> getObjectType() {
        return CuratorFramework.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}

