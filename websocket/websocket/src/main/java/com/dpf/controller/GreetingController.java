package com.dpf.controller;

import com.dpf.bean.Chat;
import com.dpf.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * @author dpf
 * @create 2020-01-16 16:01
 * @email 446933040@qq.com
 */
@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /*@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Chat greeting( Chat message){
        return message;
    }*/

    @MessageMapping("/hello")
    public void greeting( Message message){
       simpMessagingTemplate.convertAndSend("/topic/greetings",message);
    }


    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat) {
        chat.setFrom(principal.getName());
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }


}
