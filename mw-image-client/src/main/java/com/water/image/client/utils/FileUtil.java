package com.water.image.client.utils;


import com.water.image.client.model.FileData;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhang miaojie on 2017/11/9.
 */
public class FileUtil {
    public final static String UPLOAD_FILE_PATH = "/upload/";
    public final static String UPLOAD_FILE_THUMBNAIL_PATH = "/upload/thumbnail/";
    public final static String UPLOAD_FILE_BMIDDLE_PATH = "/upload/bmiddle/";
    public final static String UPLOAD_FILE_ORIGINAL_PATH = "/upload/original/";

    /**
     * 创建文件传输对象
     *
     * @param bytes
     * @param filePath
     * @return
     */
    public static FileData generateFileData(byte[] bytes, String filePath, String remoteFilePath) {
        FileData fileData = new FileData();
        fileData.suffixName = filePath.substring(filePath.lastIndexOf(".") + 1);
        fileData.filePath = remoteFilePath;
        fileData.fileBuff = ByteBuffer.wrap(bytes);
        return fileData;
    }

    /**
     * 判断客户端上传路径是否合法
     *
     * @param filePath
     * @return
     */
    public static Boolean isLegalPath(String filePath) {
        if (filePath != null && filePath.indexOf(UPLOAD_FILE_PATH) != -1) {
            return true;
        }
        return false;
    }

    /**
     * 生成各种不同的压缩格式
     *
     * @param byteArray
     * @param filepath
     * @return
     */
    public static List<FileData> generateFileDataList(byte[] byteArray, String filepath) {
        String suffix = getSuffix(filepath);
        String timeFormat = DateUtils.DATE_FORMAT_YMWITHOUT_SEPARATOR.format(new Date()) + "/" +
                DateUtils.DATE_FORMAT_D_WITHOUT_SEPARATOR.format(new Date());
        List<FileData> fileDataList = new ArrayList<>();
        byte[] thumbnailByteArr = ImageUtil.compressImage(new ByteArrayInputStream(byteArray), suffix, 0.5f);
        FileData thumbnailFileData = generateFileData(thumbnailByteArr, filepath, UPLOAD_FILE_THUMBNAIL_PATH + timeFormat);
        byte[] bmiddleByteArr = ImageUtil.compressImage(new ByteArrayInputStream(byteArray), suffix, 0.8f);
        FileData bmiddleFileData = generateFileData(bmiddleByteArr, filepath, UPLOAD_FILE_BMIDDLE_PATH + timeFormat);
        byte[] originalByteArr = ImageUtil.compressImage(new ByteArrayInputStream(byteArray), suffix, 1f);
        FileData originalFileData = generateFileData(originalByteArr, filepath, UPLOAD_FILE_ORIGINAL_PATH + timeFormat);
        fileDataList.add(thumbnailFileData);
        fileDataList.add(bmiddleFileData);
        fileDataList.add(originalFileData);
        return fileDataList;
    }

    /**
     * 按照比例，压缩图片的字节
     * @param filepath 文件的路径
     * @param byteArr 文件的字节数组
     * @param scala   压缩比例
     * @return byte[]
     */
    public static byte[] compressWithScala(String filepath, byte[] byteArr, float scala) {
        String suffix = getSuffix(filepath);
        return ImageUtil.compressImage(new ByteArrayInputStream(byteArr), suffix, 0.5f);
    }

    private static String getSuffix(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
    }

    public static void main(String[] args) {
        System.out.println(getSuffix("ddd.png"));
    }
}
