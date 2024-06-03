package sho03.essay.backend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sho03.essay.backend.service.EssayService

@RestController
@RequestMapping("api/essay")
class EssayController(
    private val essayService: EssayService
) {

    @PostMapping("/proofreading")
    fun proofreading(
        @RequestBody request: ProofreadingRequest
    ): ResponseEntity<Response> {
        val result = essayService.proofreading(request.text)
        return ResponseEntity.ok(Response(result))
    }

    data class ProofreadingRequest(
        val text: String
    )
    
    data class Response(
        val result: String
    )
}
