package com.mq.rocket;

import org.apache.rocketmq.client.apis.ClientConfiguration;
import org.apache.rocketmq.client.apis.ClientServiceProvider;

import java.time.Duration;

/**
 * @author xl-9527
 * @since 2025/2/24
 **/
public class RocketMQConfig {

    public static final ClientConfiguration CONFIGURATION = ClientConfiguration.newBuilder()
            .setEndpoints("192.168.4.81:8080")
            .setRequestTimeout(Duration.ofHours(1))
            .enableSsl(false)
            .build();

    public static ClientServiceProvider getProductServer() {
        return ClientServiceProvider.loadService();
    }
}
