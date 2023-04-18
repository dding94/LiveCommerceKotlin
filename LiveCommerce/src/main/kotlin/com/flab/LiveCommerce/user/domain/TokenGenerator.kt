package com.flab.LiveCommerce.user.domain

interface TokenGenerator {
    fun generate(): String
}
