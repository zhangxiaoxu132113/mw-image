package com.water.image.server.test;

import com.water.image.server.mq.MessageThreadService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.Destination;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2017/12/26.
 */
public class JmsThreadTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        final MessageThreadService ms = (MessageThreadService) (ctx.getBean("messageThreadService"));
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Destination destination = new ActiveMQQueue("upload.image.queue");
        for (int i = 1; i <= 4; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(new Random().nextInt(3) * 500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "处理发送消息" + i);
                        ms.sendMessage(destination, "你好:" + Thread.currentThread().getName() + "的消息" + i);
                    }
                }
            });
        }
    }
}
