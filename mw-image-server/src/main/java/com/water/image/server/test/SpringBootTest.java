package com.water.image.server.test;

import com.water.image.client.model.FileData;
import com.water.image.server.mq.MessageThreadService;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * Created by admin on 2017/12/26.
 */
@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {
    @Autowired
    private MessageThreadService producer;

    @Test
    public void contextLoads() throws InterruptedException {
        Destination destination = new ActiveMQQueue("upload.image.queue");

        for (int i = 0; i < 20; i++) {
            FileData fileData = new FileData();
            fileData.setSuffixName(i + ".jpg");
            fileData.setFilePath("/usr/upload/" + i);
            fileData.setFileBuff(new byte[5]);
            producer.sendMessage(destination, fileData);
        }
    }
}
