package com.flab.LiveCommerce.user.domain

import com.flab.LiveCommerce.common.auth.AuthenticatedUser

interface TokenRepository {
    fun save(authenticatedUser: AuthenticatedUser)
    fun findByToken(token: String?): AuthenticatedUser
    fun renewExpirationSec(authenticatedUser: AuthenticatedUser)
    fun remove(token: String?)
}
