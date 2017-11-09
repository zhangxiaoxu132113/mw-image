package test;

import com.water.image.client.ImageUploadClient;

/**
 *
 * Created by zhang miaojie on 2017/11/9.
 */
public class MainTest {

    public static void main(String[] args) {
        String localFilePath = "E:\\dayin.html";
        String remoteFilePath = "d:\\";
        String filePath = ImageUploadClient.uploadImageWithFilePath(localFilePath, remoteFilePath);
        System.out.println(filePath);
    }
}
