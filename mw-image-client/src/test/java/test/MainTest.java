package test;

import com.water.image.client.ImageUploadClient;

/**
 *
 * Created by zhang miaojie on 2017/11/9.
 */
public class MainTest {

    public static void main(String[] args) {
        String localFilePath = "https://img.meikew.com/uploads/2015/05/onsd00884pl.jpg";
        String remoteFilePath = "d:\\";
        String filePath = ImageUploadClient.uplaodImageWithFileUrl(localFilePath);
        System.out.println(filePath);
    }
}
