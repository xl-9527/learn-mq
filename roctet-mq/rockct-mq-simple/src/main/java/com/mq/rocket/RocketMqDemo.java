package com.mq.rocket;

import org.apache.rocketmq.client.apis.ClientConfiguration;
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

    private final static String TOPIC = "test";

    public static final ClientConfiguration CONFIGURATION = ClientConfiguration.newBuilder()
            .setEndpoints("http://localhost:8080")
            .build();

    public static void main(String[] args) {
        final RocketMqDemo rocketMqDemo = new RocketMqDemo();
        final ClientServiceProvider productServer = rocketMqDemo.getProductServer();
        rocketMqDemo.sendMessage(productServer, rocketMqDemo.builtMessage(productServer, "hello rocket mq"));
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
        try (final Producer producer = client.newProducerBuilder()
                .setClientConfiguration(CONFIGURATION)
                .build()) {
            // send msg
            producer.send(msg);
        } catch (ClientException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
