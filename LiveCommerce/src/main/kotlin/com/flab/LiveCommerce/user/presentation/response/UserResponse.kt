package com.flab.LiveCommerce.user.presentation.response

import com.flab.LiveCommerce.user.application.result.UserResult

data class UserResponse(
    val id: Long,
    val email: String,
    val nickname: String,
) {

    companion object {
        fun form(userResult: UserResult) = UserResponse(
            id = userResult.id,
            email = userResult.email,
            nickname = userResult.nickname,
        )

        fun logOut() = "LogOut OK"

        fun checkEmail() = "No Duplicated email"
    }
}
