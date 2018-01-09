package com.water.image.server.mq;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ZMJ on 2017/12/26.
 */
@Component("consumerThreadMessageListener")
public class ConsumerThreadMessageListener implements MessageListener {
    private ExecutorService threadPool = Executors.newFixedThreadPool(6);

    public ConsumerThreadMessageListener() {
    }

    @Override
    public void onMessage(final Message message) {
        threadPool.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("接收线程" + Thread.currentThread().getName() + "接收消息:" + ((TextMessage) message).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
