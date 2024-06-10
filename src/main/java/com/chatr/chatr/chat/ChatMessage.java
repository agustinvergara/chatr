package com.chatr.chatr.chat;

import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ChatMessage{

	private String content;
    public String sender;
    public MessageType type;
}
