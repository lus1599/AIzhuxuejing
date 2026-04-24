package com.zz.entities;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class AiApi {

    // Getters and Setters
    private String requestId;

    private Usage usage;

    private Output output;

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    // Usage 类
    public static class Usage {
        @SerializedName("input_tokens")
        private int inputTokens;

        @SerializedName("output_tokens")
        private int outputTokens;

        // Getters and Setters
        public int getInputTokens() {
            return inputTokens;
        }

        public void setInputTokens(int inputTokens) {
            this.inputTokens = inputTokens;
        }

        public int getOutputTokens() {
            return outputTokens;
        }

        public void setOutputTokens(int outputTokens) {
            this.outputTokens = outputTokens;
        }
    }

    // Output 类
    public static class Output {
        private List<Choice> choices;

        // Getters and Setters
        public List<Choice> getChoices() {
            return choices;
        }

        public void setChoices(List<Choice> choices) {
            this.choices = choices;
        }
    }

    // Choice 类
    public static class Choice {
        @SerializedName("finish_reason")
        private String finishReason;

        private Message message;

        // Getters and Setters
        public String getFinishReason() {
            return finishReason;
        }

        public void setFinishReason(String finishReason) {
            this.finishReason = finishReason;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }

    // Message 类
    public static class Message {
        private String role;
        private String content;

        // Getters and Setters
        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}