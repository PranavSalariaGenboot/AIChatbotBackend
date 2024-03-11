package com.genboot.aichatbot.service;

import com.genboot.aichatbot.dto.ChatMessage;
import com.genboot.aichatbot.dto.ChatRequest;

public interface AIChat {
    ChatMessage getAIResponse(ChatRequest chatRequest);
}
