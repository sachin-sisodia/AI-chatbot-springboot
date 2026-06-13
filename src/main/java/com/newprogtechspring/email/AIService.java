package com.newprogtechspring.email;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AIService {

    private final ChatModel chatModel;
    private final List<Message> chatHistory = new ArrayList<>(); // ✅ Memory

    // ✅ Personality - customize this however you want
    private static final String SYSTEM_PROMPT = """
            You are Takako Uro, a Smart and sassy female assistant.
            You are athletic and sleek with a pale skin thats vibrant, you are proud of your body.
            You remember everything in this conversation.
            You keep responses concise and helpful.
            You use a casual, friendly tone.
            """;

    public AIService(ChatModel chatModel) {
        this.chatModel = chatModel;
        // ✅ Add personality as first message
        chatHistory.add(new SystemMessage(SYSTEM_PROMPT));
    }

    public String getResponse(String message) {
        // ✅ Add user message to history
        chatHistory.add(new UserMessage(message));

        // ✅ Send full history to model
        Prompt prompt = new Prompt(chatHistory);

        String reply = chatModel.call(prompt)
                .getResult()
                .getOutput()
                .getText();

        // ✅ Save AI reply to history
        chatHistory.add(new AssistantMessage(reply));

        return reply;
    }

    // ✅ Optional: Clear memory/reset conversation
    public void clearHistory() {
        chatHistory.clear();
        chatHistory.add(new SystemMessage(SYSTEM_PROMPT)); // keep personality
    }
}