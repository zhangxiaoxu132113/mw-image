package com.water.image.server.task;

import com.water.image.client.model.FileData;
import com.water.image.client.utils.Constant;
import com.water.image.server.utils.UploadFileHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * 文件上传线程
 * Created by mrwater on 2017/11/11.
 */
public class UploadFileTask implements Callable {
    private FileData fileData;

    public UploadFileTask() {
    }

    public UploadFileTask(FileData fileData) {
        this.fileData = fileData;
    }

    @Override
    public String call() throws Exception {
        return saveFile2Local(fileData);
    }

    /**
     * 核心方法，将文件保存到本地 - [暂时，这里的处理是阻塞]
     */
    private String saveFile2Local(FileData fileData) {
        FileOutputStream fos;
        FileChannel channel = null;
        String filePath = UploadFileHelper.getUploadFilePath(fileData);
        try {
            File file = new File(Constant.UPLOAD_FILEPATH + filePath);
            fos = new FileOutputStream(file);
            channel = fos.getChannel();
            channel.write(fileData.fileBuff);
            return Constant.IMAGE_HOSTNAME + filePath;
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
