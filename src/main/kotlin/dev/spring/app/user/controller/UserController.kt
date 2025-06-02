package dev.spring.app.user.controller

import dev.spring.app.common.ResponseWrapper
import dev.spring.app.user.dto.UserDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import dev.spring.app.user.service.UserService
import org.springframework.http.ResponseEntity

@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/user")
    fun getProducts(
        @RequestParam(
            name = "name",
            required = false
        ) name: String?
    ): ResponseEntity<ResponseWrapper<UserDTO>> {
        return if (name.isNullOrBlank()) {
            ResponseEntity.badRequest().body(ResponseWrapper("error", "You must provide a 'name' parameter"))
        } else {
            val users = userService.getUserByEmail(name)
            ResponseEntity.ok(ResponseWrapper(status = null, message = null, data = users.firstOrNull()))
        }
    }

    @GetMapping("/users")
    fun getAllProducts(): List<UserDTO> {
        return userService.getUsers()
    }
}