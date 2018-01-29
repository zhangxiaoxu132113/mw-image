package com.water.image.client;

import com.water.image.client.utils.Constant;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by zhang miaojie on 2017/11/9.
 */
class AppClient {
    private static TBinaryProtocol tBinaryProtocol;

    static TBinaryProtocol getTBinaryProtocol() {
        if (tBinaryProtocol == null) {
            synchronized (AppClient.class) {
                if (tBinaryProtocol == null) {
                    TSocket socket = null;
                    TBinaryProtocol binaryProtocol = null;
                    TFramedTransport framedTransport = null;
                    try {
                        socket = new TSocket(Constant.SERVER_IP, Constant.SERVER_PORT);// 构造Thrift客户端，发起请求
                        socket.setSocketTimeout(Constant.SOCKET_TIMEOUT);
                        framedTransport = new TFramedTransport(socket);
                        framedTransport.open();
                        binaryProtocol = new TBinaryProtocol(framedTransport);
                        return binaryProtocol;
                    } catch (TTransportException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return tBinaryProtocol;
    }

    /**
     * 释放资源
     */
    synchronized static void retrunResource() {
        if (tBinaryProtocol != null) {
            tBinaryProtocol = null;
        }
    }
}
