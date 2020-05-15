package com.dpf.rabbitmq_demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dpf
 * @create 2020-05-14 22:22
 * @email 446933040@qq.com
 */
@Configuration
public class RabbitTopicConfig {

    public static final String TOPICNAME = "pikachues-topic";

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(TOPICNAME,true,false);
    }

    @Bean
    Queue xiaomi(){
        return new Queue("xiaomi");
    }

    @Bean
    Queue huaiwei(){
        return new Queue("huawei");
    }

    @Bean
    Queue phone(){
        return new Queue("phone");
    }

    @Bean
    Binding xiaomiBinding(){
        return BindingBuilder.bind(xiaomi()).to(topicExchange()).with("xiaomi.#");
    }

    @Bean
    Binding huaiweiBinding(){
        return BindingBuilder.bind(huaiwei()).to(topicExchange()).with("huawei.#");
    }
    @Bean
    Binding phoneBinding(){
        return BindingBuilder.bind(phone()).to(topicExchange()).with("#.phone.#");
    }

}
