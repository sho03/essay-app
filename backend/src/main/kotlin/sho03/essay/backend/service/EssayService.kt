package sho03.essay.backend.service

import org.springframework.stereotype.Service
import sho03.essay.backend.domain.ai.ProofreadingProcessor

@Service
class EssayService(
    private val proofreadingProcessor: ProofreadingProcessor
) {

    fun proofreading(text: String): String {
        val result = proofreadingProcessor.proofreading(text)
        return result
    }
}
