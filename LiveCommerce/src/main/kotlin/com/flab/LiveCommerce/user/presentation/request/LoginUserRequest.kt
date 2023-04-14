package com.flab.LiveCommerce.user.presentation.request

import com.flab.LiveCommerce.user.application.command.LoginUserCommand
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class LoginUserRequest(
    @field:NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식에 맞춰 주세요.")
    val email: String? = null,

    @field:NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^[0-9a-z].{6,10}$", message = "영문 소문자, 숫자 6~10자 이내로 입력하세요.”")
    val password: String? = null,
) {
    fun toCommand() = LoginUserCommand(
        email = email!!,
        password = password!!,
    )
}
