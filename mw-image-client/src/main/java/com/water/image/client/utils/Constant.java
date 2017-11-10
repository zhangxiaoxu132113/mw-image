package com.water.image.client.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by admin on 2017/11/10.
 */
public final class Constant {
    public static String SERVER_IP;
    public static Integer SERVER_PORT;
    public static Integer SOCKET_TIMEOUT;

    public static String IMAGE_HOSTNAME;
    public static String UPLOAD_FILEPATH;

    private static final Logger logger = LoggerFactory.getLogger(Constant.class);

    static {
        try {
            Properties prop = new Properties();
            InputStream fis =  Thread.currentThread().getClass().getResourceAsStream("/config.properties");
            prop.load(fis);
            SERVER_IP = prop.getProperty("server.ip");
            SERVER_PORT = Integer.valueOf(prop.getProperty("server.port"));
            SOCKET_TIMEOUT = Integer.valueOf(prop.getProperty("socket.timeout"));

            IMAGE_HOSTNAME = prop.getProperty("image.hostname");
            UPLOAD_FILEPATH = prop.getProperty("upload.filepath");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


