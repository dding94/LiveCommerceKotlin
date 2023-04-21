package com.flab.LiveCommerce.user.infrastructure.encryption

import com.flab.LiveCommerce.user.domain.PasswordEncryptor
import org.springframework.security.crypto.password.PasswordEncoder

class UserSecurityPasswordEncoder(private val passwordEncoder: PasswordEncoder) : PasswordEncryptor {

    override fun encrypt(text: String): String {
        return passwordEncoder.encode(text)
    }

    override fun match(rawText: String, encryptedText: String): Boolean {
        return passwordEncoder.matches(rawText, encryptedText)
    }
}
