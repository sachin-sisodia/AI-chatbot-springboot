package com.newprogtechspring.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final AIService openAIService;

    public ChatController(AIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/chat")
    public ChatResponse message(@RequestBody ChatRequest request) {
        String reply = openAIService.getResponse(request.getMessage());
        return new ChatResponse(reply);
    }

    // ✅ Add reset endpoint
    @PostMapping("/chat/reset")
    public ChatResponse reset() {
        openAIService.clearHistory();
        return new ChatResponse("Conversation cleared!");
    }
}