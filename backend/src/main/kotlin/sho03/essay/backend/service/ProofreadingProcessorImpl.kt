package sho03.essay.backend.service

import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import sho03.essay.backend.config.OpenAIConfigurations
import sho03.essay.backend.domain.ai.OpenAIMessage
import sho03.essay.backend.domain.ai.OpenAIRequest
import sho03.essay.backend.domain.ai.OpenAIResponse
import sho03.essay.backend.domain.ai.ProofreadingProcessor

@Service
class ProofreadingProcessorImpl(
    private val openAIConfigurations: OpenAIConfigurations,
    private val restTemplate: RestTemplate
) : ProofreadingProcessor {

    val apiKey = openAIConfigurations.apiKey
    val apiUrl = openAIConfigurations.apiUrl
    val model = openAIConfigurations.model
    val maxTokens = openAIConfigurations.maxTokens
    val prompt = openAIConfigurations.prompt

    override fun proofreading(text: String): String {

        val headers = HttpHeaders().apply {
            set("Authorization", "Bearer $apiKey")
            accept = listOf(MediaType.APPLICATION_JSON)
        }
        val requestBody = OpenAIRequest(model, maxTokens, listOf(
            OpenAIMessage(
                role = "system",
                content = prompt
            ),
            OpenAIMessage(
                role = "user",
                content = text
            )
        ))
        val entity = HttpEntity(requestBody, headers)
        val response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, OpenAIResponse::class.java)
        val body = response.body
        if (body != null) {
            return body.choices[0].message.content
        } else {
            throw RuntimeException("Failed to proofreading")
        }
    }
}
