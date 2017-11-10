package test;

import com.water.image.client.ImageUploadClient;

/**
 *
 * Created by zhang miaojie on 2017/11/9.
 */
public class MainTest {

    public static void main(String[] args) {
        String localFilePath = "http://img.2cto.com/Collfiles/20171109/20171109141044222.jpg";
        String remoteFilePath = "d:\\";
        String filePath = ImageUploadClient.uplaodImageWithFileUrl(localFilePath);
        System.out.println(filePath);
    }
}
