package com.flab.LiveCommerce.user.presentation.request

import com.flab.LiveCommerce.user.application.command.CreateUserCommand
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class CreateUserRequest(
    @field:NotBlank @Email
    val email: String? ,

    @field:NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^[0-9a-z].{6,10}$", message = "영문 소문자, 숫자 6~10자 이내로 입력하세요.”")
    val password: String?,

    @field:NotBlank
    val nickname: String?
) {
    fun toCommand() = CreateUserCommand(
        email = email!!,
        password = password!!,
        nickname = nickname!!
    )
}