package com.water.image;

import com.water.image.model.FileData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by admin on 2017/11/9.
 */
public class FileUtil {
    public final static String UPLOAD_FILE_PATH = "/upload/%s";

    /**
     * 创建文件传输对象
     *
     * @param bytes
     * @param filePath
     * @return
     */
    public static FileData generateFileData(byte[] bytes, String filePath) {
        String strs[] = filePath.split("\\\\");
        FileData fileData = new FileData();
        fileData.filename = strs[strs.length - 1];
        System.out.println(fileData.filename);
        fileData.filepath = filePath;
        fileData.buff = ByteBuffer.wrap(bytes);

        return fileData;
    }

    public static void main(String[] args) {
        generateFileData(null, "E:\\dayin.html");
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

    /**
     * 核心方法，将文件保存到本地 - [暂时，这里的处理是阻塞]
     *
     * @param filePath 文件的路径
     * @param buff     字节数组
     */
    public static String saveFile2Local(String filePath, ByteBuffer buff) {
        FileOutputStream fos;
        FileChannel channel = null;
        try {
            File file = new File(filePath);
            fos = new FileOutputStream(file);
            channel = fos.getChannel();
            channel.write(buff);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
