package com.flab.LiveCommerce.user.application.command

import com.flab.LiveCommerce.user.domain.User

data class CreateUserCommand(var email: String, var password: String, var nickname: String){
    fun toEntity(encryptedPassword: String?): User = User(email, encryptedPassword, nickname)
}
