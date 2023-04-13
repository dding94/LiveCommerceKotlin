package com.flab.LiveCommerce.user.presentation.response

import com.flab.LiveCommerce.user.application.result.UserResult
import com.flab.user.application.result.UserResult

class UserResponse {
    var id: Long? = null
        private set
    var email: String? = null
        private set
    var nickname: String? = null
        private set

    private constructor()
    constructor(id: Long?, email: String?, nickname: String?) {
        this.id = id
        this.email = email
        this.nickname = nickname
    }

    companion object {
        fun from(userResult: UserResult): UserResponse {
            return UserResponse(userResult.id, userResult.email, userResult.nickname)
        }

        fun logOut(): String {
            return "Logout OK"
        }

        fun checkEmail(): String {
            return "No duplicate emails"
        }
    }
}
