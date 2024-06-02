package sho03.essay.backend.domain.ai

import com.fasterxml.jackson.annotation.JsonProperty

data class OpenAIRequest(
    val model: String,
    @JsonProperty("max_tokens")
    val maxTokens: Int,
    val messages: List<OpenAIMessage>
)
