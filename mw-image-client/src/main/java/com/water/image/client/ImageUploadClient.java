package com.water.image.client;

import com.water.image.client.model.FileData;
import com.water.image.client.service.FileService;
import com.water.image.client.utils.FileUtil;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;

import java.util.Date;

import static com.water.image.client.utils.DateUtils.DATE_FORMAT_YMD_2;

/**
 * 文件上传客户端
 * Created by zhang miaojie on 2017/11/9.
 */
public class ImageUploadClient extends AppClient {

    /**
     * 默认上传文件路径
     */
    private static final String DEFAULT_UPLOAD_FILE_PATH = String.format(FileUtil.UPLOAD_FILE_PATH, DATE_FORMAT_YMD_2.format(new Date()));

    public static String uploadImageWithFilePath(String localFilePath) {
        return uploadImageWithFilePath(localFilePath, DEFAULT_UPLOAD_FILE_PATH);
    }

    /**
     * 上传图片
     *
     * @param localFilePath  本地文件地址
     * @param remoteFilePath 图片上传服务器地址
     */
    public static String uploadImageWithFilePath(String localFilePath, String remoteFilePath) {
        try {
            FileData fileData = FileUtil.generateFileData(toByteArray(localFilePath), localFilePath, remoteFilePath);// 构造文件数据
            uploadFile(fileData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String uplaodImageWithFileUrl(String fileUrl) {
        return uplaodImageWithFileUrl(fileUrl, DEFAULT_UPLOAD_FILE_PATH);
    }

    /**
     * 上传图片
     *
     * @param fileUrl        图片url地址
     * @param remoteFilePath 图片上传服务器地址
     */
    public static String uplaodImageWithFileUrl(String fileUrl, String remoteFilePath) {
        try {
            FileData fileData = FileUtil.generateFileData(toByteArrayWithUrl(fileUrl), fileUrl, remoteFilePath);// 构造文件数据
            return uploadFile(fileData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String uploadFile(FileData fileData) throws TException {
        TBinaryProtocol binaryProtocol = getTBinaryProtocol();
        FileService.Client client = new FileService.Client(binaryProtocol);
        return client.uploadFile(fileData);
    }


}
