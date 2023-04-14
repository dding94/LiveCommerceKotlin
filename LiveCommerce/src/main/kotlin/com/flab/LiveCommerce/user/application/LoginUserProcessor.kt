package com.flab.LiveCommerce.user.application

import com.flab.LiveCommerce.user.application.command.LoginUserCommand
import com.flab.LiveCommerce.user.domain.exception.UserPasswordNotMatchedException
import com.flab.common.auth.AuthenticatedUser

class LoginUserProcessor(
    userRepository: UserRepository,
    tokenGenerator: TokenGenerator,
    tokenRepository: TokenRepository,
    passwordEncryptor: PasswordEncryptor,
    tokenExpirationSec: Long
) {
    private val userRepository: UserRepository
    private val tokenGenerator: TokenGenerator
    private val tokenRepository: TokenRepository
    private val passwordEncryptor: PasswordEncryptor
    private val tokenExpirationSec: Long

    init {
        this.userRepository = userRepository
        this.tokenGenerator = tokenGenerator
        this.tokenRepository = tokenRepository
        this.passwordEncryptor = passwordEncryptor
        this.tokenExpirationSec = tokenExpirationSec
    }

    fun execute(command: LoginUserCommand): String {
        val user: Unit = userRepository.findByEmail(command.email)
        if (!checkPassword(command, user)) {
            throw UserPasswordNotMatchedException()
        }
        val token: Unit = tokenGenerator.generate()
        tokenRepository.save(
            AuthenticatedUser.create(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole(),
                tokenExpirationSec
            )
        )

        return token
    }

    private fun checkPassword(command: LoginUserCommand, user: User): Boolean {
        return passwordEncryptor.match(command.getPassword(), user.getPassword())
    }
}
