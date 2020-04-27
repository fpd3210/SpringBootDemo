package com.dpf.activemq_demo;

import com.dpf.activemq_demo.bean.Message;
import com.dpf.activemq_demo.config.JmsComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ActivemqDemoApplicationTests {

    @Autowired
    JmsComponent jmsComponent;


    @Test
    void contextLoads() {
        Message message = new Message();
        message.setContent("hello pikachues");
        message.setSendDate(new Date());
        jmsComponent.send(message);
    }

}
