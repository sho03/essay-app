package sho03.essay.backend.domain.ai

interface ProofreadingProcessor {
    fun proofreading(text: String): String
}
