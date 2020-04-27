package com.dpf.activemq_demo.config;

import com.dpf.activemq_demo.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author dpf
 * @create 2020-04-25 11:57
 * @email 446933040@qq.com
 */
@Component
public class JmsComponent {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    Queue queue;

    public void send(Message message){
        jmsMessagingTemplate.convertAndSend(this.queue,message);
    }

    @JmsListener(destination = "hello.pikachues")
    public void receive(Message msg){
        System.out.println(msg);
    }
}
