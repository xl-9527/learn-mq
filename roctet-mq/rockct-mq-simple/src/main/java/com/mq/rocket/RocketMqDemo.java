package com.mq.rocket;

import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.message.Message;
import org.apache.rocketmq.client.apis.producer.Producer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author xl-9527
 * @since 2025/2/18
 **/
public class RocketMqDemo {

    private final static String TOPIC = "test_topic";

    public void sendMessage(final String msg) {
        final ClientServiceProvider productServer = RocketMQConfig.getProductServer();
        doSendMessage(productServer, builtMessage(productServer, msg));
    }

    private Message builtMessage(ClientServiceProvider client, String msg) {
        return client.newMessageBuilder()
                .setBody(msg.getBytes(StandardCharsets.UTF_8))
                .setTopic(TOPIC)
                .build();
    }

    private void doSendMessage(ClientServiceProvider client, Message msg) {
        try (final Producer producer = client.newProducerBuilder()
                .setClientConfiguration(RocketMQConfig.CONFIGURATION)
                .build()) {
            // send msg
            producer.send(msg);
        } catch (ClientException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
