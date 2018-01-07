package com.water.image.server.service;

import com.water.image.client.service.FileService;
import com.water.image.client.utils.Constant;
import com.water.image.server.service.impl.FileServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Created by zhang miaojie on 2017/11/9.
 */
public class FileServer {
    private static final Logger logger = LoggerFactory.getLogger(FileServer.class);

    public static void startup() throws TTransportException {
        // 创建非阻塞的 Transport
        TNonblockingServerTransport serverSocket = new TNonblockingServerSocket(Constant.SERVER_PORT);
        // 创建 Processor
        TProcessor processor = new FileService.Processor<FileService.Iface>(new FileServiceImpl());
        // 创建 transport factory , Nonblocking 使用 TFramedTransport
        TTransportFactory transportFactory = new TFramedTransport.Factory();
        TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
        // 创建 arguments
        TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverSocket);
        tArgs.processor(processor);
        tArgs.transportFactory(transportFactory);
        tArgs.protocolFactory(protocolFactory);

        TServer server = new TThreadedSelectorServer(tArgs);
        server.serve();
        logger.info("文件传输服务启动成功！");
    }
}
