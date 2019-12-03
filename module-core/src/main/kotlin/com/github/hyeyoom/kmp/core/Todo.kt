package com.github.hyeyoom.kmp.core

data class Todo(
    val id: String,
    val title: String,
    val content: String,
    val isDone: Boolean = false,
    val createdAt: Long
)