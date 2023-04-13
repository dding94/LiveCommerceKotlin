package com.flab.LiveCommerce.user.presentation.request

import com.flab.user.application.command.LoginUserCommand
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

class LoginUserRequest {
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식에 맞춰 주세요.")
    var email: String? = null
        private set

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^[0-9a-z].{6,10}$", message = "영문 소문자, 숫자 6~10자 이내로 입력하세요.”")
    var password: String? = null
        private set

    fun toCommand(): LoginUserCommand {
        return LoginUserCommand(email, password)
    }

    private constructor()
    constructor(email: String?, password: String?) {
        this.email = email
        this.password = password
    }
}
