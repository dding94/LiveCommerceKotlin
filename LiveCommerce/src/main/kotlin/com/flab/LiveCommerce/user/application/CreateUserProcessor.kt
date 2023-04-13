package com.flab.LiveCommerce.user.application

import com.flab.user.application.command.CreateUserCommand

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
        if (userRepository.existsByEmail(command.getEmail())) {
            throw UserDuplicatedEmailException()
        }
        val encryptedPassword: String = passwordEncryptor.encrypt(command.getPassword())
        val user: Unit = userRepository.save(command.toEntity(encryptedPassword))
        return UserResult.from(user)
    }
}
