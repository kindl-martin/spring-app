package dev.spring.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringApplication

fun main(args: Array<String>) {
	runApplication<SpringApplication>(*args)
}