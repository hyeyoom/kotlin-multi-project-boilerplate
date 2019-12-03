package com.github.hyeyoom.kmp.app

import com.github.hyeyoom.kmp.core.Todo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/dummy")
class DummyController {

    @GetMapping
    fun getTodo(): Todo {
        return Todo(
            title = "hi",
            content = "내용",
            id = UUID.randomUUID().toString(),
            createdAt = System.currentTimeMillis()
        )
    }
}