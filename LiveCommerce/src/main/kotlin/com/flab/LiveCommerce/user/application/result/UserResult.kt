package com.flab.LiveCommerce.user.application.result

import com.flab.LiveCommerce.user.domain.User

data class UserResult(
    val id: Long,
    val email: String,
    val nickname: String
) {

    companion object {
        fun form(user: User): UserResult = UserResult(user.id, user.email, user.nickname)
    }
}

