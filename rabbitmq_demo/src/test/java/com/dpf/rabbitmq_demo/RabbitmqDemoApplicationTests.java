package com.dpf.rabbitmq_demo;


import com.dpf.rabbitmq_demo.config.RabbitFanoutConfig;
import com.dpf.rabbitmq_demo.config.RabbitHeaderConfig;
import com.dpf.rabbitmq_demo.config.RabbitTopicConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Queue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDemoApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Test
	public void direct() {
		rabbitTemplate.convertAndSend("hello.pikachues","hello pikachues");
	}


	@Test
	public void testFanout(){
		rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME,null,"hello Fanout");
	}

	@Test
	public void testTopic(){
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.news","小米新闻");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"vivo.phone","小米手机");
		rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"huawei.phone","华为手机");
	}

	@Test
	public void testHeaders(){
		Message nameMsg = MessageBuilder.withBody("hello pikachues".getBytes()).setHeader("name","pikachues").build();
		Message ageMsg = MessageBuilder.withBody("hello 99".getBytes()).setHeader("age","99").build();
		rabbitTemplate.convertAndSend(RabbitHeaderConfig.HEADERNAME,null,nameMsg);
		rabbitTemplate.convertAndSend(RabbitHeaderConfig.HEADERNAME,null,ageMsg);
	}
}
