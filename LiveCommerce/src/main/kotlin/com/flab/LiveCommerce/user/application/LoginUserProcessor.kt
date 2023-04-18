package com.flab.LiveCommerce.user.application

import com.flab.LiveCommerce.common.auth.AuthenticatedUser
import com.flab.LiveCommerce.user.application.command.LoginUserCommand
import com.flab.LiveCommerce.user.domain.*
import com.flab.LiveCommerce.user.domain.exception.UserPasswordNotMatchedException

class LoginUserProcessor(
    private val userRepository: UserRepository,
    private val tokenGenerator: TokenGenerator,
    private val tokenRepository: TokenRepository,
    private val passwordEncryptor: PasswordEncryptor,
    private val tokenExpirationSec: Long,
) {


    fun execute(command: LoginUserCommand): String {
        val user = userRepository.findByEmail(command.email)

        if (!checkPassword(command, user)) {
            throw UserPasswordNotMatchedException()
        }

        val token = tokenGenerator.generate()

        tokenRepository.save(
            AuthenticatedUser.create(
                token,
                user.id,
                user.email,
                user.role,
                tokenExpirationSec
            )
        )

        return token
    }

    private fun checkPassword(command: LoginUserCommand, user: User): Boolean {
        return passwordEncryptor.match(command.password, user.password)
    }
}
