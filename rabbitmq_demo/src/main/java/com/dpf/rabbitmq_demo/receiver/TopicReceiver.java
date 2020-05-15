package com.dpf.rabbitmq_demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author dpf
 * @create 2020-05-14 22:29
 * @email 446933040@qq.com
 */
@Component
public class TopicReceiver {
    @RabbitListener(queues = "xiaomi")
    public void handler1(String msg) {
        System.out.println("TopicReceiver:handler1:" + msg);
    }

    @RabbitListener(queues = "huawei")
    public void handler2(String msg) {
        System.out.println("TopicReceiver:handler2:" + msg);
    }

    @RabbitListener(queues = "phone")
    public void handler3(String msg) {
        System.out.println("TopicReceiver:handler3:" + msg);
    }
}
