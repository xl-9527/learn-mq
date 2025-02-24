package com.mq.rocket;

import org.apache.rocketmq.client.apis.ClientConfiguration;
import org.apache.rocketmq.client.apis.ClientServiceProvider;

/**
 * @author xl-9527
 * @since 2025/2/24
 **/
public class RocketMQConfig {

    public static final ClientConfiguration CONFIGURATION = ClientConfiguration.newBuilder()
            .setEndpoints("192.168.4.81:8080")
            .build();

    public static ClientServiceProvider getProductServer() {
        return ClientServiceProvider.loadService();
    }
}
