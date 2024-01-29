package com.haan.anywaygoodhappen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
//chatGPT에 요청할 DTO Format
public class ChatGptRequest implements Serializable {
    private String model;
    @JsonProperty("max_tokens")
    private Integer maxTokens;
    private Double temperature;
    @JsonProperty("top_p")
    private Double topP;
    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;
    @JsonProperty("presence_penalty")
    private Double presencePenalty;
    private List<ChatGptMessage> messages;

    //@JsonProperty("top_p")
    //private Double topP;

    @Builder
    public ChatGptRequest(String model, Integer maxTokens, Double temperature,
                          Double topP, Double frequencyPenalty, Double presencePenalty,
                           List<ChatGptMessage> messages
            /*,Double topP*/) {
        this.model = model;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
        this.topP = topP;
        this.frequencyPenalty = frequencyPenalty;
        this.presencePenalty = presencePenalty;
        this.messages = messages;
        //this.topP = topP;
    }
}
