package com.water.image.server;

import com.water.image.server.service.FileServer;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/1/9.
 */
@Component
public class StartListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        try {
            System.out.println("启动thrift图片上传的服务.");
            FileServer.startup();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
