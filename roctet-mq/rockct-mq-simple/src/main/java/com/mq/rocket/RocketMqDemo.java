package com.mq.rocket;

import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @author xl-9527
 * @since 2025/2/18
 **/
public class RocketMqDemo {

    private final static String TOPIC = "test";

    public static void main(String[] args) {
    }

    private ClientServiceProvider getProductServer() {
        return ClientServiceProvider.loadService();
    }

    private Message builtMessage(ClientServiceProvider client, String msg) {
        return client.newMessageBuilder()
                .setBody(msg.getBytes(StandardCharsets.UTF_8))
                .setTopic(TOPIC)
                .build();
    }

    private void sendMessage(ClientServiceProvider client, Message msg) {
        client.getProducerBuilder()
                .setTransactionalMessageHook(new TransactionalMessageHook())
                .build()
                .send(msg);
    }
}
