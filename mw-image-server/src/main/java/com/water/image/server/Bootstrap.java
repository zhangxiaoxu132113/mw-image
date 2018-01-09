package com.water.image.server;

import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBoot Micro service startup class
 * Created by zhangmiaojie on 2017/11/11.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.water.image.server")
public class Bootstrap {
    public static void main(String[] args) throws TTransportException {
        SpringApplication.run(Bootstrap.class, args);
    }
}
