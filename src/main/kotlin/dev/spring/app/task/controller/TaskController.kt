package dev.spring.app.task.controller

import dev.spring.app.common.ResponseWrapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import dev.spring.app.task.entity.Task
import dev.spring.app.task.service.TaskService
import org.springframework.http.ResponseEntity

@RestController
class TaskController (
    private val taskService: TaskService
) {

    @GetMapping("/task")
    fun getCategory(@RequestParam(name = "name", required = false) name: String?): ResponseEntity<ResponseWrapper<Task>> {
        return ResponseEntity.badRequest().body(ResponseWrapper("error", "You must provide a 'name' parameter"))
    }

    @GetMapping("/tasks")
    fun getAllTasks(): List<Task> {
        return taskService.getTasks()
    }
}