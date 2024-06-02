package sho03.essay.backend.domain.ai

data class OpenAIChoice(
   val index: Int,
    val message: OpenAIMessage
)
