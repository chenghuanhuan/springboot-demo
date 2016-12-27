/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.chenghuan.client;

import java.io.IOException;

/**
 * @author chenghuanhuan@qccr.com
 * @since $Revision:1.0.0, $Date: 2016年12月27日 下午4:09 $
 */
public class TestApp {
    public static void main(String[] args) throws IOException {

            for (int i=0;i<100;i++) {
                new ClientThread2().start();
            }

    }
}
