package com.flab.LiveCommerce.user.application.command

class LoginUserCommand {
    var email: String? = null
        private set
    var password: String? = null
        private set

    private constructor()
    constructor(email: String?, password: String?) {
        this.email = email
        this.password = password
    }
}
