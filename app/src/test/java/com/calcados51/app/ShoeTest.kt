package com.calcados51.app

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for the Shoe data model.
 */
class ShoeTest {

    @Test
    fun shoe_defaultIsOutOfStock_isFalse() {
        val shoe = Shoe(
            id = 1,
            name = "Tênis Teste",
            brand = "Marca Teste",
            description = "Descrição teste",
            price = 99.99,
            imageResId = 0
        )
        assertFalse(shoe.isOutOfStock)
    }

    @Test
    fun shoe_canBeMarkedAsOutOfStock() {
        val shoe = Shoe(
            id = 1,
            name = "Tênis Teste",
            brand = "Marca Teste",
            description = "Descrição teste",
            price = 99.99,
            imageResId = 0
        )
        shoe.isOutOfStock = true
        assertTrue(shoe.isOutOfStock)
    }

    @Test
    fun shoe_canBeMarkedBackInStock() {
        val shoe = Shoe(
            id = 1,
            name = "Tênis Teste",
            brand = "Marca Teste",
            description = "Descrição teste",
            price = 99.99,
            imageResId = 0,
            isOutOfStock = true
        )
        shoe.isOutOfStock = false
        assertFalse(shoe.isOutOfStock)
    }

    @Test
    fun shoe_dataClassEquality() {
        val shoe1 = Shoe(1, "Tênis", "Marca", "Desc", 100.0, 0)
        val shoe2 = Shoe(1, "Tênis", "Marca", "Desc", 100.0, 0)
        assertEquals(shoe1, shoe2)
    }
}
