package com.flab.LiveCommerce.user.domain

interface UserRepository {
    fun save(user: User): User
    fun findByEmail(email: String): User
    fun existsByEmail(email: String): Boolean
}
