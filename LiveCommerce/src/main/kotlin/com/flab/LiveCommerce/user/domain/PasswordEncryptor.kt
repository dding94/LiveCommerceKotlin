package com.flab.LiveCommerce.user.domain

interface PasswordEncryptor {
    fun encrypt(text: String): String

    fun match(rawText: String, encryptedText: String): Boolean
}
