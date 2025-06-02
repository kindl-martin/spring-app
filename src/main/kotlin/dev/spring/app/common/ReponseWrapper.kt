package dev.spring.app.common

data class ResponseWrapper<T>(
    val status: String?,
    val message: String? = null,
    val data: T? = null
)