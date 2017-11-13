package com.water.image.client.utils;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mrwater on 2017/11/11.
 */
public class ImageUtil {

    /**
     * 图片压缩|放大
     * @param fromPic
     * @param suffix
     * @param scaleValue
     * @return
     */
    public static byte[] compressImage(InputStream fromPic, String suffix, float scaleValue) {
        try {
            BufferedImage bufferedImage = Thumbnails.of(fromPic).scale(scaleValue).asBufferedImage();//按比例缩小
            return imageToBytes(bufferedImage, suffix);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换BufferedImage 数据为byte数组
     *
     * @param bImage
     * Image对象
     * @param format
     * image格式字符串.如"gif","png"
     * @return byte数组
     */
    public static byte[] imageToBytes(BufferedImage bImage, String format) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, format, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}
