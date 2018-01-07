package com.water.image.server.utils;

import com.water.image.client.model.FileData;
import com.water.image.client.utils.Constant;

import java.io.File;
import java.util.UUID;

/**
 * Created by admin on 2017/12/27.
 */
public class UploadFileHelper {
    /**
     * 获取上传文件的路径
     *
     * @param fileData
     * @return
     */
    public static String getUploadFilePath(FileData fileData) {
        String suffixName = fileData.getSuffixName();
        String fileName = UUID.randomUUID().toString();
        File filePath = new File(Constant.UPLOAD_FILEPATH + fileData.getFilePath());
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        return fileData.getFilePath() + "/" + fileName + "." + suffixName;
    }
}
