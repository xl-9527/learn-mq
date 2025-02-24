package com.mq.rocket;


/**
 * @author xl-9527
 * @since 2025/2/24
 **/
class RocketMqDemoTest {

    private final RocketMqDemo rocketMqDemo = new RocketMqDemo();

    void sendMessage() {
        rocketMqDemo.sendMessage("hello world");
    }
}
