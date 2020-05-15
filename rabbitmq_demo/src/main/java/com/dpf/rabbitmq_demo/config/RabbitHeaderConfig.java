package com.dpf.rabbitmq_demo.config;

import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dpf
 * @create 2020-05-14 22:21
 * @email 446933040@qq.com
 */
@Configuration
public class RabbitHeaderConfig {

    public static final String HEADERNAME = "pikachues-header";

    @Bean
    HeadersExchange headersExchange(){
        return new HeadersExchange(HEADERNAME, true,false);
    }

    @Bean
    Queue queueName(){
        return new Queue("name-queue");
    }
    @Bean
    Queue queueAge(){
        return new Queue("age-queue");
    }
    @Bean
    Binding bindingName(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","pikachues");
        return BindingBuilder.bind(queueName()).to(headersExchange()).whereAny(map).match();
    }

    @Bean
    Binding bindingAge(){
        return BindingBuilder.bind(queueAge()).to(headersExchange()).where("age").exists();
    }
}
