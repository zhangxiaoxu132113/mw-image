package com.water.image.client;

import com.water.image.client.model.FileData;
import com.water.image.client.model.RequestResult;
import com.water.image.client.service.FileService;
import com.water.image.client.utils.ByteUtil;
import com.water.image.client.utils.DateUtils;
import com.water.image.client.utils.FileUtil;
import com.water.image.client.utils.ImageUtil;
import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

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

    /**
     * 上传图片
     *
     * @param localFilePath 本地图片的路径
     * @return RequestResult
     */
    public static RequestResult uploadImageWithFilePath(String localFilePath) {
        return uploadImageWithFilePath(localFilePath, DEFAULT_UPLOAD_FILE_PATH);
    }

    /**
     * 上传图片
     *
     * @param localFilePath  本地文件地址
     * @param remoteFilePath 图片上传服务器地址
     */
    public static RequestResult uploadImageWithFilePath(String localFilePath, String remoteFilePath) {
        try {
            FileData fileData = FileUtil.generateFileData(ByteUtil.toByteArray(localFilePath), localFilePath, remoteFilePath);// 构造文件数据
            uploadFile(fileData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fail();
    }

    /**
     * 上传图片
     *
     * @param fileUrl 图片url地址
     * @return RequestResult
     */
    public static RequestResult uplaodImageWithFileUrl(String fileUrl) {
        return uplaodImageWithFileUrl(fileUrl, DEFAULT_UPLOAD_FILE_PATH, 1);
    }

    /**
     * 上传图片
     *
     * @param fileUrl       图片url地址
     * @param compressScale 图片压缩的比例
     * @return RequestResult
     */
    public static RequestResult uplaodImageWithFileUrlAndCompressScale(String fileUrl, float compressScale) {
        return uplaodImageWithFileUrl(fileUrl, DEFAULT_UPLOAD_FILE_PATH, compressScale);
    }

    public static RequestResult uplaodImageWithFileUrlByCompress(String fileUrl) throws TException {
        byte[] imageByte = ByteUtil.toByteArrayWithUrl(fileUrl);
        return uploadImage(imageByte, fileUrl, true);
    }

    /**
     * 上传图片
     *
     * @param fileUrl        图片url地址
     * @param remoteFilePath 图片上传服务器地址
     * @param compressScale  图片压缩的比例
     */
    public static RequestResult uplaodImageWithFileUrl(String fileUrl, String remoteFilePath, float compressScale) {
        try {
            byte[] imageByte = ByteUtil.toByteArrayWithUrl(fileUrl);
            byte[] compressScaleByteArr = FileUtil.compressWithScala(fileUrl, imageByte, compressScale); // 文件压缩
            FileData fileData = FileUtil.generateFileData(compressScaleByteArr, fileUrl, remoteFilePath);// 构造文件数据
            return uploadFile(fileData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RequestResult();
    }

    /**
     * 上传图片 返回图片的三种压缩格式（压缩比例，分别是1f, 0.8f, 0.5f）
     *
     * @param byteArray
     * @param fileName
     * @return
     * @throws TException
     */
    public static RequestResult uploadImage(byte[] byteArray, String fileName) throws TException {
        FileData fileData = FileUtil.generateFileData(byteArray, fileName, DEFAULT_UPLOAD_FILE_PATH);// 构造文件数据
        return uploadFile(fileData);
    }


    /**
     * 上传图片
     *
     * @param byteArray  图片字节数组
     * @param fileName   图片文件名
     * @param isCompress 是否压缩图片
     * @return RequestResult
     * @throws TException
     */
    public static RequestResult uploadImage(byte[] byteArray, String fileName, boolean isCompress) throws TException {
        if (!isCompress) {
            return uploadImage(byteArray, fileName);
        }
        List<FileData> fileDataList = FileUtil.generateFileDataList(byteArray, fileName);
        TBinaryProtocol binaryProtocol = getTBinaryProtocol();
        FileService.Client client = new FileService.Client(binaryProtocol);
        return client.uploadFileList(fileDataList);
    }

    public static RequestResult uploadFile(FileData fileData) throws TException {
        TBinaryProtocol binaryProtocol = getTBinaryProtocol();
        FileService.Client client = new FileService.Client(binaryProtocol);
        return client.uploadFile(fileData);
    }

    public static RequestResult fail() {
        RequestResult result = new RequestResult();
        result.setCode(-1);
        result.setDesc("请求失败！");
        return result;
    }
}
