package com.water.image.server.mq;

import com.water.image.client.model.FileData;
import com.water.image.server.task.UploadFileTask;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 上传图片文件的消费者
 * Created by ZMJ on 2017/12/26.
 */
@Component
public class UploadImageCustomer {
    private ExecutorService threadPool = Executors.newFixedThreadPool(6);

    @JmsListener(destination = "upload.image.queue")
    public void receiveQueue(final FileData message) {
        threadPool.submit(new UploadFileTask(message));
    }
}