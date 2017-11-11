package test;

import com.water.image.client.ImageUploadClient;
import org.apache.thrift.TException;

/**
 *
 * Created by zhang miaojie on 2017/11/9.
 */
public class MainTest {

    public static void main(String[] args) throws TException {
        String localFilePath = "http://img.zcool.cn/community/01bd375a0413c7a80121985cca0f70.jpg@1280w_1l_2o_100sh.jpg";
        String remoteFilePath = "d:\\";
        String filePath = ImageUploadClient.uplaodImageWithFileUrlByCompress(localFilePath);
        System.out.println(filePath);
    }
}
