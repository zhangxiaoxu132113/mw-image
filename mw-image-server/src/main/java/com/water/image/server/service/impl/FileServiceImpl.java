package com.water.image.server.service.impl;


import com.water.image.client.model.FileData;
import com.water.image.client.service.FileService;
import com.water.image.client.utils.FileUtil;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件服务业务类
 * Created by zhang miaojie on 2017/11/9.
 */
public class FileServiceImpl implements FileService.Iface {

    private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String uploadFile(FileData filedata) throws TException {
        logger.info("uploadFile function has been called.");
        this.checkFileData(filedata);
        return FileUtil.saveFile2Local(filedata.filepath, filedata.buff);
    }

    /**
     * 校验上传的filedata合法
     * @param fileData
     */
    private void checkFileData(FileData fileData) {
        String filePath;
        if (fileData == null) {
            throw new RuntimeException("文件对象不能为空！");
        }
        filePath = fileData.filepath;
        if (!FileUtil.isLegalPath(filePath)) {
            throw new RuntimeException("文件服务器上传地址不合法法");
        }
    }
}
