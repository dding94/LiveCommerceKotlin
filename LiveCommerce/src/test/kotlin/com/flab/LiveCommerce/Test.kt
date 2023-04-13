package com.flab.LiveCommerce

import org.junit.jupiter.api.Test
import java.lang.Exception

class Test {

    private var a: String? = null

    @Test
    fun test1() {


        val b: String?  = null
        val c = b?.length ?: "a"

        println(c)

    }

    private fun failFast(s: String): Nothing {
        throw IllegalArgumentException(s)
    }
}