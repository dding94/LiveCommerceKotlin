package com.flab.LiveCommerce.user.application.facade

import com.flab.LiveCommerce.user.application.CheckEmailProcessor
import com.flab.LiveCommerce.user.application.CreateUserProcessor
import com.flab.LiveCommerce.user.application.LoginUserProcessor
import com.flab.LiveCommerce.user.application.LogoutUserProcessor
import com.flab.LiveCommerce.user.application.command.CreateUserCommand
import com.flab.LiveCommerce.user.application.command.LoginUserCommand
import com.flab.LiveCommerce.user.application.result.UserResult
import org.springframework.stereotype.Service

@Service
class UserManager(
    private val createUserProcessor: CreateUserProcessor,
    private val loginUserProcessor: LoginUserProcessor,
    private val logoutUserProcessor: LogoutUserProcessor,
    private val checkEmailProcessor: CheckEmailProcessor,
) {

    fun createUser(command: CreateUserCommand): UserResult {
        return createUserProcessor.execute(command)
    }

    fun login(command: LoginUserCommand): String {
        return loginUserProcessor.execute(command)
    }

    fun logout(token: String) {
        logoutUserProcessor.execute(token)
    }

    fun checkEmail(email: String?) {
        checkEmailProcessor.execute(email)
    }
}
