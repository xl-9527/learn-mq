package com.mq.rocket;

import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.producer.Producer;

import java.io.IOException;

/**
 * @author xl-9527
 * @since 2025/2/24
 **/
public class RocketMqTopicDemo {

    private final String TOPIC;

    public RocketMqTopicDemo(final String topic) {
        TOPIC = topic;
    }

    public void createTopic() {
        ClientServiceProvider productServer = RocketMQConfig.getProductServer();
        try (Producer build = productServer.newProducerBuilder()
                .build()) {

        } catch (ClientException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
