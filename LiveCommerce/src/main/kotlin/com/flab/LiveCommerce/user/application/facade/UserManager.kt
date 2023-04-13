package com.flab.LiveCommerce.user.application.facade

import com.flab.LiveCommerce.user.application.CheckEmailProcessor
import com.flab.LiveCommerce.user.application.CreateUserProcessor
import com.flab.LiveCommerce.user.application.LoginUserProcessor
import com.flab.LiveCommerce.user.application.LogoutUserProcessor
import com.flab.LiveCommerce.user.application.command.CreateUserCommand
import com.flab.LiveCommerce.user.application.command.LoginUserCommand
import com.flab.LiveCommerce.user.application.result.UserResult
import com.flab.user.application.CheckEmailProcessor
import org.springframework.stereotype.Service

@Service
class UserManager(
    createUserProcessor: CreateUserProcessor,
    loginUserProcessor: LoginUserProcessor,
    logoutUserProcessor: LogoutUserProcessor,
    checkEmailProcessor: CheckEmailProcessor
) {
    private val createUserProcessor: CreateUserProcessor
    private val loginUserProcessor: LoginUserProcessor
    private val logoutUserProcessor: LogoutUserProcessor
    private val checkEmailProcessor: CheckEmailProcessor

    init {
        this.createUserProcessor = createUserProcessor
        this.loginUserProcessor = loginUserProcessor
        this.logoutUserProcessor = logoutUserProcessor
        this.checkEmailProcessor = checkEmailProcessor
    }

    fun createUser(command: CreateUserCommand?): UserResult {
        return createUserProcessor.execute(command)
    }

    fun login(command: LoginUserCommand?): String {
        return loginUserProcessor.execute(command)
    }

    fun logout(token: String?) {
        logoutUserProcessor.execute(token)
    }

    fun checkEmail(email: String?) {
        checkEmailProcessor.execute(email)
    }
}
