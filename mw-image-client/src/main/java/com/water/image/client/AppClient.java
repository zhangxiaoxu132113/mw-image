package com.water.image.client;

import com.water.image.client.model.FileData;
import com.water.image.client.service.FileService;
import com.water.image.client.utils.FileUtil;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by admin on 2017/11/9.
 */
public class AppClient {
    private static String SERVER_IP;
    private static Integer SERVER_PORT;
    private static Integer SOCKET_TIME_OUT;

    static {
        SERVER_IP = "localhost";
        SERVER_PORT = 12345;
        SOCKET_TIME_OUT = 60 * 1000;
    }

    public static void main(String[] args) {
        String filePath = "E:\\dayin.html";
        FileData fileData = FileUtil.generateFileData(toByteArray(filePath), filePath);// 构造文件数据
        try {
            TBinaryProtocol binaryProtocol = getTBinaryProtocol();
            FileService.Client client = new FileService.Client(binaryProtocol);
            client.uploadFile(fileData);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    protected static TBinaryProtocol getTBinaryProtocol() {
        TSocket socket = null;
        TFramedTransport framedTransport = null;
        TBinaryProtocol binaryProtocol = null;
        try {
            socket = new TSocket(SERVER_IP, SERVER_PORT);// 构造Thrift客户端，发起请求
            socket.setSocketTimeout(SOCKET_TIME_OUT);
            framedTransport = new TFramedTransport(socket);
            framedTransport.open();
            binaryProtocol = new TBinaryProtocol(framedTransport);
            return binaryProtocol;
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件转化为字节数组
     */
    protected static byte[] toByteArray(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
