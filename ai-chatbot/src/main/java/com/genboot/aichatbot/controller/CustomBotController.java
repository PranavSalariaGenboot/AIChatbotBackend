package com.genboot.aichatbot.controller;

import com.genboot.aichatbot.dto.*;
import com.genboot.aichatbot.service.impl.AIChatImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/v1/bot")
public class CustomBotController {
    @Autowired
    private AIChatImpl aiChat;

    @GetMapping("/chat")
    public ChatMessage chat(@RequestBody ChatRequest chatRequest) {
        return aiChat.getAIResponse(chatRequest);
    }
}
