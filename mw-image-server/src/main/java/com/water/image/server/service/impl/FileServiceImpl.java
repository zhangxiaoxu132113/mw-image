package com.water.image.server.service.impl;


import com.water.image.client.model.FileData;
import com.water.image.client.model.RequestResult;
import com.water.image.client.service.FileService;
import com.water.image.client.utils.FileUtil;
import com.water.image.server.task.UploadFileTask;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

/**
 * 文件服务业务类
 * Created by zhang miaojie on 2017/11/9.
 */
public class FileServiceImpl implements FileService.Iface {

    private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    @Override
    public RequestResult uploadFile(final FileData fileData) throws TException {
        RequestResult result = new RequestResult();
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
        result.setCode(0);
        result.setDesc("操作成功！");
        result.setOriginal(returnFilePath);
        return result;
    }

    @Override
    public RequestResult uploadFileList(List<FileData> fileDataList) throws TException {
        RequestResult result = new RequestResult();
        if (fileDataList == null || fileDataList.size() <= 0) {
            result.setCode(-1);
            result.setDesc("fileData集合不能为空!");
            return result;
        }
        fileDataList.stream().forEach(p -> {
            try {
                RequestResult resulttmp = this.uploadFile(p);
                if (resulttmp.getOriginal() != null && resulttmp.getOriginal().contains(FileUtil.UPLOAD_FILE_ORIGINAL_PATH)) {
                    result.setOriginal(resulttmp.getOriginal());
                } else if (resulttmp.getOriginal() != null && resulttmp.getOriginal().contains(FileUtil.UPLOAD_FILE_BMIDDLE_PATH)) {
                    result.setBmiddle(result.getOriginal());
                } else if (resulttmp.getOriginal() != null && resulttmp.getOriginal().contains(FileUtil.UPLOAD_FILE_THUMBNAIL_PATH)) {
                    result.setThumbnail(result.getOriginal());
                }
            } catch (TException e) {
                e.printStackTrace();
            }
        });

        result.setCode(1);
        result.setDesc("操作成功！");
        return result;
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
