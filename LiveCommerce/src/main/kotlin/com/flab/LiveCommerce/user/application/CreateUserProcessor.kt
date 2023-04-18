package com.flab.LiveCommerce.user.application

import com.flab.LiveCommerce.user.application.command.CreateUserCommand
import com.flab.LiveCommerce.user.application.result.UserResult
import com.flab.LiveCommerce.user.domain.PasswordEncryptor
import com.flab.LiveCommerce.user.domain.User
import com.flab.LiveCommerce.user.domain.UserRepository
import com.flab.LiveCommerce.user.domain.exception.UserDuplicatedEmailException


class CreateUserProcessor(
    userRepository: UserRepository,
    passwordEncryptor: PasswordEncryptor
) {
    private val userRepository: UserRepository
    private val passwordEncryptor: PasswordEncryptor

    init {
        this.userRepository = userRepository
        this.passwordEncryptor = passwordEncryptor
    }

    fun execute(command: CreateUserCommand): UserResult {
        if (userRepository.existsByEmail(command.email)) {
            throw UserDuplicatedEmailException()
        }
        val encryptedPassword: String = passwordEncryptor.encrypt(command.password)
        val user: User = userRepository.save(command.toEntity(encryptedPassword))
        return UserResult.form(user)
    }
}
