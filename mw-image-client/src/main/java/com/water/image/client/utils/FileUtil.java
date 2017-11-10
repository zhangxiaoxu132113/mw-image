package com.water.image.client.utils;


import com.water.image.client.model.FileData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.UUID;

/**
 * Created by zhang miaojie on 2017/11/9.
 */
public class FileUtil {
    public final static String UPLOAD_FILE_PATH = "/upload/";

    /**
     * 创建文件传输对象
     *
     * @param bytes
     * @param filePath
     * @return
     */
    public static FileData generateFileData(byte[] bytes, String filePath, String remoteFilePath) {
        FileData fileData = new FileData();
        fileData.suffixName = filePath.substring(filePath.lastIndexOf(".") + 1);
        fileData.filePath = remoteFilePath;
        fileData.fileBuff = ByteBuffer.wrap(bytes);
        return fileData;
    }

    /**
     * 判断客户端上传路径是否合法
     *
     * @param filePath
     * @return
     */
    public static Boolean isLegalPath(String filePath) {
        if (filePath != null && filePath.indexOf(UPLOAD_FILE_PATH) != -1) {
            return true;
        }
        return false;
    }
}
