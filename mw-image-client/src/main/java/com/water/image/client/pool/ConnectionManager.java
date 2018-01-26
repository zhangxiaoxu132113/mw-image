package com.water.image.client.pool;

import lombok.Data;

/**
 * 连接池管理者
 * Created by zhangmiaojie on 2018/1/24.
 */
@Data
public class ConnectionManager {
    private ConnectionPool connectionPool;
    private ConnectionConfig connectionConfig;

    private ConnectionManager() {
    }

    public void setConnectionConfig(ConnectionConfig config) {
        this.connectionConfig = config;
        this.connectionPool = new ConnectionPool(config);
    }

    public static ConnectionManager getInstance() {
        return ConnectionManagerHolder.INSTANCE;
    }

    private static final class ConnectionManagerHolder {
        static ConnectionManager INSTANCE = new ConnectionManager();
    }
}
