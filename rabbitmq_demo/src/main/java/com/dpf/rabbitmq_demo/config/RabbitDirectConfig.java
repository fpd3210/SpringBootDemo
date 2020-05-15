package com.dpf.rabbitmq_demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author dpf
 * @create 2020-05-14 18:39
 * @email 446933040@qq.com
 */
@Configuration
public class RabbitDirectConfig {
    public final static String DIRECTNAME = "pikachues-direct";

    /**
     * 只有这一个就行
     * @return
     */
    @Bean
    Queue queue() {
        return new Queue("hello.pikachues");
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(DIRECTNAME,true,false);
    }

    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}
