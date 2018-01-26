package com.water.image.client.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Created by zhangmiaojie on 2018/1/24.
 */
@Slf4j
public class ConnectionPool {
    private ConcurrentLinkedQueue<ConnectionHandle> connPool;
    private BlockingQueue<ConnectionHandle> freeConnections;
    private BlockingQueue<ConnectionHandle> busyConnections;

    private volatile boolean poolShuttingDown = false;

    private ConnectionConfig connectionConfig;

    private AtomicInteger createdConnections = new AtomicInteger(0);

    protected ExecutorService connectionScheduler;

    public ConnectionPool(ConnectionConfig connectionConfig) {
        this.connectionConfig = connectionConfig;
    }

    public void close(){}

    public ConnectionHandle getConnectionHandle(){return null;}

    public void returnConnection(ConnectionHandle connectionHandle) {}

    public void releaseConnection(ConnectionHandle connectionHandle){}

    private void fillConnections(int createConnections) {

    }

    public boolean isConnectionAlive(ConnectionHandle connectionHandle) {return false;}

    public ConnectionConfig getConnectionConfig() {
        return connectionConfig;
    }

    public void setConnectionConfig(ConnectionConfig connectionConfig) {
        this.connectionConfig = connectionConfig;
    }
}
