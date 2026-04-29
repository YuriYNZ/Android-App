package com.calcados51.app

/**
 * Data model representing a shoe product.
 *
 * @property id Unique identifier for the shoe.
 * @property name Display name of the shoe.
 * @property brand Brand name.
 * @property description Short product description.
 * @property price Price in BRL.
 * @property imageResId Drawable resource id for the shoe image.
 * @property isOutOfStock Whether the item is currently out of stock.
 */
data class Shoe(
    val id: Int,
    val name: String,
    val brand: String,
    val description: String,
    val price: Double,
    val imageResId: Int,
    var isOutOfStock: Boolean = false
)
