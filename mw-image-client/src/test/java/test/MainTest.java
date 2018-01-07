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
        String localFilePath = "http://www.uubook.net:80/asset/ad/0.jpg";
        RequestResult result = ImageUploadClient.uplaodImageWithFileUrlByCompress(localFilePath);
        System.out.println(result.getOriginal());
        System.out.println(result.getBmiddle());
        System.out.println(result.getThumbnail());


    }
}
