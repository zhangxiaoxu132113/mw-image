package com.water.image.client.pool;

import lombok.Data;
import org.apache.thrift.transport.TSocket;

/**
 *
 * Created by zmj on 2018/1/29.
 */
@Data
public class ThriftTSocket extends TSocket {

    private String host;
    private int port;
    private int timeout;

    public ThriftTSocket(String host, int port, int timeout) {
        super(host, port, timeout);
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }
}
