package com.flab.LiveCommerce.user.infrastructure.generator

import com.flab.LiveCommerce.user.domain.TokenGenerator
import java.util.*

class NonInfoTokenGenerator : TokenGenerator {
    override fun generate(): String {
        return UUID.randomUUID().toString()
    }
}
