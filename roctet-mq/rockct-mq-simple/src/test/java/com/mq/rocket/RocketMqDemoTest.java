package com.mq.rocket;


import org.junit.jupiter.api.Test;

/**
 * @author xl-9527
 * @since 2025/2/24
 **/
class RocketMqDemoTest {

    private final RocketMqDemo rocketMqDemo = new RocketMqDemo();

    @Test
    void sendMessage() {
        rocketMqDemo.sendMessage("hello world");
    }
}
