package com.flab.LiveCommerce

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LiveCommerceApplicationTests {

    @Test
    fun contextLoads() {
        val coffee = Coffee("바리스타", 10000)
        coffee.iced = true

        val dog: Animal = Dog()

        println(dog.age)
        println(dog.mea())


    }

    open class Animal {
        var age: Int = 0

        fun mea() {
            println("meaa")
        }
    }

    class Dog : Animal() {

    }


    class Coffee(
        val name: String,
        private var price: Int,
        var iced: Boolean = false,
    ) {
        fun changePrice(input: Int): Int {
            this.price += input
            return this.price
        }

        var quantity: Int = 0
            set(value) {
                if (value > 0) {
                    field = value
                }
            }

    }
}
