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
public class AppClient {

    protected static TBinaryProtocol getTBinaryProtocol() {
        TSocket socket = null;
        TFramedTransport framedTransport = null;
        TBinaryProtocol binaryProtocol = null;
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

    /**
     * 根据文件的url地址获取字节数组
     * @param fileUrl
     * @return
     */
    protected static byte[] toByteArrayWithUrl(String fileUrl) {
        byte[] resultData = null;
        java.net.URL url = null;
        java.io.InputStream is = null;
        java.io.ByteArrayOutputStream baos = null;
        try {
            url = new java.net.URL(fileUrl);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() == 200) {
                is =  conn.getInputStream();
                baos = new java.io.ByteArrayOutputStream();
                int buffer = 1024;
                byte[] b = new byte[buffer];
                int n = 0;
                while ((n = is.read(b, 0, buffer)) > 0) {
                    baos.write(b, 0, n);
                }
                resultData = baos.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return resultData;
    }

}
