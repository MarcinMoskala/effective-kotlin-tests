package org.kotlinacademy

import org.openjdk.jmh.annotations.*
import java.util.concurrent.*
import java.util.concurrent.*
import java.util.ArrayList

fun <T> Iterable<T>.noinlineFilter(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

fun <T> Iterable<T>.noinlineSumByDouble(selector: (T) -> Double): Double {
    var sum = 0.0
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

inline fun <T> Iterable<T>.filterInline(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

inline fun <T> Iterable<T>.sumByDoubleInline(selector: (T) -> Double): Double {
    var sum = 0.0
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

data class Product(val price: Double, val bought: Boolean)

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
open class InlineFilterBenchmark {

    lateinit var products: List<Product>

    @Setup
    fun init() {
        products = (1..5_000).map { Product(10.0, true) }
    }

    @Benchmark
    fun filterInline() {
        products.filterInline { it.bought }.sumByDoubleInline { it.price }
    }

    @Benchmark
    fun filterNoninline() {
        products.noinlineFilter { it.bought }.noinlineSumByDouble { it.price }
    }
}