package com.water.image.client.pool;

import lombok.Data;

import java.io.Serializable;

/**
 * 连接池配置类
 * Created by zmj on 2018/1/24.
 */
@Data
public class ConnectionConfig implements Serializable {
    /**
     * 主机名
     */
    private String host;
    /**
     * 端口号
     */
    private int port;
    /**
     * 超时时间
     */
    private int timeout;
    /**
     * 最大连接数
     */
    private int maxConnections;
    /**
     * 最小连接数
     */
    private int minConnections;
    /**
     * 线程池的名字
     */
    private String poolName;
    /**
     * 是否预加载
     */
    private boolean preLoad;
}
