package com.flab.LiveCommerce.user.application

import com.flab.LiveCommerce.user.domain.UserRepository
import com.flab.LiveCommerce.user.domain.exception.UserDuplicatedEmailException

class CheckEmailProcessor(userRepository: UserRepository) {
    private val userRepository: UserRepository

    init {
        this.userRepository = userRepository
    }

    fun execute(email: String) {
        if (userRepository.existsByEmail(email)) {
            throw UserDuplicatedEmailException()
        }
    }
}
