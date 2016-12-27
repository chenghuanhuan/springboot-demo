/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.chenghuan.client;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author chenghuanhuan@qccr.com
 * @since $Revision:1.0.0, $Date: 2016年12月27日 下午4:23 $
 */
public class ClientThread2 extends Thread {

    @Override
    public void run() {
        // open websocket
        WebsocketClientEndpoint clientEndPoint = null;
        try {
            clientEndPoint = new WebsocketClientEndpoint(new URI("ws://localhost:9090/websocket"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (clientEndPoint != null) {
            // add listener
            clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                    System.out.println(message);
                }
            });
        }

        // send message to websocket
        clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
