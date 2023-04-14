package com.flab.LiveCommerce.user.presentation

import com.flab.LiveCommerce.common.CommonApiResponse
import com.flab.LiveCommerce.user.application.facade.UserManager
import com.flab.LiveCommerce.user.application.result.UserResult
import com.flab.LiveCommerce.user.presentation.request.CreateUserRequest
import com.flab.LiveCommerce.user.presentation.request.LoginUserRequest
import com.flab.LiveCommerce.user.presentation.request.UserEmailRequest
import com.flab.LiveCommerce.user.presentation.response.UserResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/users")
@RestController
class UserController(
    private val userManager: UserManager,
) {
    @PostMapping
    fun signUp(@RequestBody request: CreateUserRequest): CommonApiResponse<UserResponse> {
        val user: UserResult = userManager.createUser(request.toCommand())
        return CommonApiResponse.success(UserResponse.form(user))
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginUserRequest): CommonApiResponse<String> {
        val token: String = userManager.login(request.toCommand())
        return CommonApiResponse.success(token)
    }


    @PostMapping("/email/check")
    fun checkEmail(@RequestBody request: UserEmailRequest): CommonApiResponse<String> {
        userManager.checkEmail(request.email)
        return CommonApiResponse.success(UserResponse.checkEmail())
    }
}
