package test;

import com.water.image.client.ImageUploadClient;
import com.water.image.client.model.RequestResult;
import org.apache.logging.log4j.spi.CopyOnWrite;
import org.apache.thrift.TException;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 *
 * Created by zhang miaojie on 2017/11/9.
 */
public class MainTest {

    public static void main(String[] args) throws TException {
        String localFilePath = "http://img.uubook.net/upload/bmiddle/201801/06/12e6e69e-3dcb-4d73-a5eb-115898534383.png";
//        RequestResult result = ImageUploadClient.uplaodImageWithFileUrlByCompress(localFilePath);
//        System.out.println(result.getOriginal());
//        System.out.println(result.getBmiddle());
//        System.out.println(result.getThumbnail());

        ImageUploadClient.uplaodImageWithFileUrl(localFilePath, true);

    }
}
