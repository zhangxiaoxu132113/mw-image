package com.water.image.client.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件转换字节数组的工具类
 * Created by zhangmiaojie on 2018/1/9.
 */
public class ByteUtil {

    /**
     * 文件转化为字节数组
     * @param filePath 图片的本地路径
     * @return 图片字节数组
     */
    public static byte[] toByteArray(String filePath) {
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
     * @param fileUrl 图片的url地址
     * @return 图片字节数组
     */
    public static byte[] toByteArrayWithUrl(String fileUrl) {
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
