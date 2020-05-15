package com.dpf.rabbitmq_demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author dpf
 * @create 2020-05-14 19:06
 * @email 446933040@qq.com
 */
@Component
public class DirectReceiver {

    @RabbitListener(queues = "hello.pikachues")
    public void handler1(String msg){
        System.out.println(">>>handler"+msg);
    }
}
