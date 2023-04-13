package com.flab.LiveCommerce.user.application.result

import com.flab.LiveCommerce.user.domain.User

data class UserResult (var id: Long, var email: String, var nickname: String){
    companion object {
        fun from(user: User): UserResult {
            return UserResult(user.id, user.email, user.nickname)
        }
    }
}

