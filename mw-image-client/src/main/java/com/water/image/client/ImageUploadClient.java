package com.water.image.client;

import com.water.image.FileUtil;
import com.water.image.model.FileData;
import com.water.image.service.FileService;
import org.apache.thrift.protocol.TBinaryProtocol;

/**
 * 文件上传客户端
 * Created by zhang miaojie on 2017/11/9.
 */
public class ImageUploadClient extends AppClient {

    /**
     * 上传图片
     *
     * @param localFilePath  本地文件地址
     * @param remoteFilePath 文件的字节数组
     */
    public static String uploadImageWithFilePath(String localFilePath, String remoteFilePath) {
        try {
            FileData fileData = FileUtil.generateFileData(toByteArray(localFilePath), remoteFilePath);// 构造文件数据
            TBinaryProtocol binaryProtocol = getTBinaryProtocol();
            FileService.Client client = new FileService.Client(binaryProtocol);
            return client.uploadFile(fileData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void uplaodImageWithFileUrl(String fileUrl, String remoteFilePath) {

    }


}
