package com.dpf.rabbitmq_demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author dpf
 * @create 2020-05-14 22:44
 * @email 446933040@qq.com
 */
@Component
public class FanoutReceiver {

    @RabbitListener(queues = "queue-one")
    public void handler1(String msg){
        System.out.println("FanoutReceiver:handler1"+msg);
    }

    @RabbitListener(queues = "queue-two")
    public void handler2(String msg){
        System.out.println("FanoutReceiver:handler2"+msg);
    }
}
