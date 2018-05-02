package org.kotlinacademy

data class Client(val adult: Boolean, val products: List<Product>)
data class Product(val price: Double, val bought: Boolean)
