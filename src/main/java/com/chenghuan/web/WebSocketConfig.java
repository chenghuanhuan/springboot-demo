/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.chenghuan.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author chenghuanhuan@qccr.com
 * @since $Revision:1.0.0, $Date: 2016年12月26日 下午6:35 $
 */
@Configuration
@EnableAutoConfiguration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter (){
        return new ServerEndpointExporter();
    }
    @Bean
    public MyWebSocket myWebSocket(){
        return new MyWebSocket();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebSocketConfig.class,args);
    }
}
