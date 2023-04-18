package com.flab.LiveCommerce.user.domain

import com.flab.LiveCommerce.common.auth.Role
import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var email: String,
    var password: String,
    var nickname: String,

    @Enumerated(EnumType.STRING)
    var role: Role? = Role.USER
) {
    companion object {
        fun create(email: String, password: String, nickname: String): User {
            return User(email = email, password = password, nickname = nickname)
        }
    }
}
