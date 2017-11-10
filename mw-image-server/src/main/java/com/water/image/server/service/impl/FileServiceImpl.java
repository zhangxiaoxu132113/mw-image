package com.water.image.server.service.impl;


import com.water.image.client.model.FileData;
import com.water.image.client.service.FileService;
import com.water.image.client.utils.Constant;
import com.water.image.client.utils.FileUtil;
import com.water.image.server.utils.Constants;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.UUID;

/**
 * 文件服务业务类
 * Created by zhang miaojie on 2017/11/9.
 */
public class FileServiceImpl implements FileService.Iface {

    private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String uploadFile(FileData fileData) throws TException {
        checkFileData(fileData);
        return this.saveFile2Local(fileData);
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

    /**
     * 核心方法，将文件保存到本地 - [暂时，这里的处理是阻塞]
     */
    private String saveFile2Local(FileData fileData) {
        FileOutputStream fos;
        FileChannel channel = null;
        String filePath = this.getUploadFilePath(fileData);
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

    /**
     * 获取上传文件的路径
     *
     * @param fileData
     * @return
     */
    private String getUploadFilePath(FileData fileData) {
        String suffixName = fileData.getSuffixName();
        String fileName = UUID.randomUUID().toString();
        File filePath = new File(Constants.ROOT_FILE_PATH + fileData.getFilePath());
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        return fileData.getFilePath() + "/" + fileName + "." + suffixName;
    }
}
