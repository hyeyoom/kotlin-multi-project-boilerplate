package com.github.hyeyoom.kmp.usecase.core.todo

import com.github.hyeyoom.kmp.core.Todo
import com.github.hyeyoom.kmp.usecase.core.UseCase

class CreateTodoUseCase(private val todoRepository: TodoRepository) : UseCase<Todo, String> {

    override fun execute(request: Todo): String {
        todoRepository.save(request)
        return ""
    }

    interface TodoRepository {
        fun save(todo: Todo)
    }
}