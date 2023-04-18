package com.flab.LiveCommerce.user.application

import com.flab.LiveCommerce.user.domain.TokenRepository

class LogoutUserProcessor(tokenRepository: TokenRepository) {
    private val tokenRepository: TokenRepository

    init {
        this.tokenRepository = tokenRepository
    }

    fun execute(token: String?) {
        tokenRepository.remove(token)
    }
}
