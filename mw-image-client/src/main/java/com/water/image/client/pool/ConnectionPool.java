package com.water.image.client.pool;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Created by zmj on 2018/1/24.
 */
@Slf4j
public class ConnectionPool {
    private ConcurrentLinkedQueue<ConnectionHandle> connPool;
    private BlockingQueue<ConnectionHandle> freeConnections;
    @Getter
    private BlockingQueue<ConnectionHandle> busyConnections;

    private volatile boolean poolShuttingDown = false;
    @Getter
    private ConnectionConfig connectionConfig;
    @Getter
    private AtomicInteger createdConnections = new AtomicInteger(0);

    protected ExecutorService connectionScheduler;

    public ConnectionPool(ConnectionConfig connectionConfig) {
        this.connectionConfig = connectionConfig;
        this.freeConnections = new ArrayBlockingQueue<ConnectionHandle>(connectionConfig.getMaxConnections());
        this.busyConnections = new ArrayBlockingQueue<ConnectionHandle>(connectionConfig.getMaxConnections());
        this.connPool = new ConcurrentLinkedQueue<>();
        if (connectionConfig.isPreLoad()) {
            fillConnections(connectionConfig.getMinConnections());
        }

        connectionScheduler = Executors.newFixedThreadPool(connectionConfig.getMinConnections(), null);
    }

    public void close(){}

    /**
     * 获取连接对象
     * @return
     */
    public ConnectionHandle getConnectionHandle(){
        ConnectionHandle connectionHandle = null;
        if (poolShuttingDown) {
            if (this.getAvailableConnections() == 0) {
                fillConnections(this.connectionConfig.getMinConnections());
            }
            connectionHandle = this.freeConnections.poll();
            if (connectionHandle != null) {
                connPool.add(connectionHandle);
                busyConnections.add(connectionHandle);
            }
        } else {
            throw new RuntimeException("pool is shutdown");
        }
        printConnectionCountInfo();
        return connectionHandle;
    }

    public void returnConnection(ConnectionHandle connectionHandle) {

    }

    /**
     * 释放连接
     * @param connectionHandle
     */
    public void releaseConnection(ConnectionHandle connectionHandle){
        if (!this.poolShuttingDown && connectionHandle != null) {
            connectionHandle.close();
            connPool.remove(connectionHandle);
            busyConnections.remove(connectionHandle);
            freeConnections.remove(connectionHandle);
        }
    }

    private void fillConnections(int createConnections) {
        for (int i=0; i<createConnections; i++){
            if (poolShuttingDown) {
                throw new RuntimeException("pool is shutdown");
            }
            ConnectionHandle connectionHandle = new ConnectionHandle();
            this.freeConnections.add(connectionHandle);
            this.connPool.add(connectionHandle);
        }
        printConnectionCountInfo();
    }

    /**
     * Adds a free connection.
     *
     * @param connectionHandle
     */
    public void addFreeConnection(ConnectionHandle connectionHandle) {
        updateCreatedConnections(1);
        // Insert element
        if (!this.freeConnections.offer(connectionHandle)) {
            // add connection failed. rollback.
            updateCreatedConnections(-1);
            //close connection
            connectionHandle.close();
        }
    }

    /**
     * Update created connections num.
     * @param increment
     */
    private void updateCreatedConnections(int increment) {
        createdConnections.addAndGet(increment);
    }

    protected int getAvailableConnections() {
        return this.freeConnections.size();
    }

    public boolean isConnectionAlive(ConnectionHandle connectionHandle) {return false;}

    public ConnectionConfig getConnectionConfig() {
        return connectionConfig;
    }

    public void setConnectionConfig(ConnectionConfig connectionConfig) {
        this.connectionConfig = connectionConfig;
    }

    private void printConnectionCountInfo() {
        log.info("createConnections={}, freeConnections={}, busyConnections={}", this.getCreatedConnections(), this.getAvailableConnections(), this.getBusyConnections().size());
    }
}
