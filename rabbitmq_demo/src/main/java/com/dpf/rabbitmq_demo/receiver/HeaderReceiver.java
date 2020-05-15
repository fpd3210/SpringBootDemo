package com.dpf.rabbitmq_demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author dpf
 * @create 2020-05-14 22:44
 * @email 446933040@qq.com
 */
@Component
public class HeaderReceiver {

    @RabbitListener(queues = "name-queue")
    public void handler1(byte[] msg) {
        System.out.println("HeaderReceiver:handler1:" + new String(msg, 0, msg.length));
    }

    @RabbitListener(queues = "age-queue")
    public void handler2(byte[] msg) {
        System.out.println("HeaderReceiver:handler2:" + new String(msg, 0, msg.length));
    }
}
