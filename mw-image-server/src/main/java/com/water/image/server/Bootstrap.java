package com.water.image.server;

import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBoot Micro service startup class
 * Created by zhangmiaojie on 2017/11/11.
 */
@SpringBootApplication
public class Bootstrap implements EmbeddedServletContainerCustomizer{
    public static void main(String[] args) throws TTransportException {
//        FileServer.startup();
        SpringApplication.run(Bootstrap.class, args);
    }


    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(9011);
    }
}
