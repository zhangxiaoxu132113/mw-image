package com.water.image.server.service.impl;


import com.water.image.client.model.FileData;
import com.water.image.client.service.FileService;
import com.water.image.client.utils.Constant;
import com.water.image.client.utils.FileUtil;
import com.water.image.server.task.UploadFileTask;
import com.water.image.server.utils.Constants;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * 文件服务业务类
 * Created by zhang miaojie on 2017/11/9.
 */
public class FileServiceImpl implements FileService.Iface {

    private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    @Override
    public String uploadFile(final FileData fileData) throws TException {
        String returnFilePath = null;
        Future<String> future = null;
        try {
            checkFileData(fileData);
            future = executor.submit(new UploadFileTask(fileData));
            returnFilePath = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return returnFilePath;
    }

    /**
     * 校验上传的各项参数是否合法
     *
     * @param fileData
     */
    private void checkFileData(FileData fileData) {
        if (fileData == null) {
            throw new RuntimeException("文件对象不能为空！");
        }
        if (!FileUtil.isLegalPath(fileData.filePath)) {
            throw new RuntimeException("文件服务器上传地址不合法法");
        }
    }

}
