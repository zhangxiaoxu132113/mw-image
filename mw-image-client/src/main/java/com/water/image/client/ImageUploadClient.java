package com.water.image.client;

import com.water.image.client.model.FileData;
import com.water.image.client.service.FileService;
import com.water.image.client.utils.DateUtils;
import com.water.image.client.utils.FileUtil;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;

import java.util.Date;

/**
 * 文件上传客户端
 * Created by zhang miaojie on 2017/11/9.
 */
public class ImageUploadClient extends AppClient {

    /**
     * 默认上传文件路径
     */
    private static final String DEFAULT_UPLOAD_FILE_PATH = FileUtil.UPLOAD_FILE_PATH +
            DateUtils.DATE_FORMAT_YMWITHOUT_SEPARATOR.format(new Date()) + "/" +
            DateUtils.DATE_FORMAT_D_WITHOUT_SEPARATOR.format(new Date());

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

    public static String uploadImage(byte[] byteArray, String fileName) throws TException {
        FileData fileData = FileUtil.generateFileData(byteArray, fileName, DEFAULT_UPLOAD_FILE_PATH);// 构造文件数据
        return uploadFile(fileData);
    }

    public static String uploadFile(FileData fileData) throws TException {
        TBinaryProtocol binaryProtocol = getTBinaryProtocol();
        FileService.Client client = new FileService.Client(binaryProtocol);
        return client.uploadFile(fileData);
    }
}
