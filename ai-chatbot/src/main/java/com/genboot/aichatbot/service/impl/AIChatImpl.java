package com.genboot.aichatbot.service.impl;

import com.genboot.aichatbot.dto.*;
import com.genboot.aichatbot.service.AIChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIChatImpl implements AIChat {
    @Value("${openai.model}")
    private String model;
    @Value("${openai.api.url}")
    private String apiURL;
    @Value("${sendMessage.url}")
    private String sendMessageUrl;
    @Autowired
    private RestTemplate template;
    public ChatMessage getAIResponse(ChatRequest chatRequest){
        String prompt = chatRequest.getMessage();

        ChatGPTRequest request = new ChatGPTRequest(
                "gpt-3.5-turbo",
                prompt
        );

        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);

        String aiResponse = chatGPTResponse.getChoices().get(0).getMessage().getContent();

        ChatMessage aiMessage = ChatMessage.builder()
                .type(MessageType.AIRESP)
                .sender(chatRequest.getUsername())
                .content(aiResponse)
                .build();

        return aiMessage;
    }
}
