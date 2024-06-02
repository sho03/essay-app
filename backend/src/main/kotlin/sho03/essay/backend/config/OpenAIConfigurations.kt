package sho03.essay.backend.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "openai")
class OpenAIConfigurations {
    lateinit var apiKey: String
    lateinit var apiUrl: String
    lateinit var model: String
    var maxTokens: Int  = 100
    lateinit var prompt: String
}
