package com.water.image.server;

import com.water.image.service.FileService;
import com.water.image.service.impl.FileServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.*;

/**
 * Created by admin on 2017/11/9.
 */
public class AppServer {
    public static void main(String[] args) throws TTransportException {
        // 创建非阻塞的 Transport
        TNonblockingServerTransport serverSocket = new TNonblockingServerSocket(12345);

        // 创建 Processor
        TProcessor processor = new FileService.Processor<FileService.Iface>(new FileServiceImpl());

        // 创建 transport factory , Nonblocking 使用 TFramedTransport
        TTransportFactory transportFactory = new TFramedTransport.Factory();

        // 创建 protocol factory
        TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();

        // 创建 arguments
        TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverSocket);
        tArgs.processor(processor);
        tArgs.transportFactory(transportFactory);
        tArgs.protocolFactory(protocolFactory);

        // 创建 server
        TServer server = new TThreadedSelectorServer(tArgs);

        // 启动 server
        server.serve();
    }
}
