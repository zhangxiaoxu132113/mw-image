package com.water.image.server.mq;

import com.water.image.client.model.FileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * Created by ZMJ on 2017/12/26.
 */
@Component("messageThreadService")
public class MessageThreadService {
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }

    public void sendMessage(Destination destination, final FileData message){
        jmsTemplate.convertAndSend(destination, message);
    }
}
