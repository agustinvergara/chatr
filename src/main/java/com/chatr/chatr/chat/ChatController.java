package com.chatr.chatr.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Calendar;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")

    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage

    ){
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpleMessageHeaderAccessor headerAccessor
    ) {
        //Add username in websocket session
        headerAccessor.getSessionAtributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
