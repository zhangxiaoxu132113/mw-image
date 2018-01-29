package com.water.image.client.pool;

import com.water.image.client.utils.Constant;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.io.Serializable;

/**
 * Created by zmj on 2018/1/24.
 */
public class ConnectionHandle {



    /**
     * 关闭资源
     */
    public void close() {
    }
}
