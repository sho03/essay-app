package sho03.essay.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {

    @GetMapping("/sample")
    fun sample(): String {
        return "Hello, World!"
    }
}
