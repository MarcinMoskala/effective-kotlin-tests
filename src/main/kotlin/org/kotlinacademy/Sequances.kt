package org.kotlinacademy

import org.openjdk.jmh.annotations.*
import java.util.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
open class SequancesBenchmark {

    lateinit var productsList: List<Client>

    @Setup
    fun init() {
        productsList = List(1000) {
            Client(
                    adult = it % 10 != 1,
                    products = (1..50).map { Product(1.0 * it / 100, true) }
            )
        }
    }

    @Benchmark
    fun simpleSequenceProcessing(): Double {
        return generateSequence(0) { it }
                .take(1000)
                .filter { it % 2 == 1 }
                .map { it * 2 }
                .average()
    }

    @Benchmark
    fun simpleListProcessing(): Double {
        return List(1000) { it }
                .filter { it % 2 == 1 }
                .map { it * 2 }
                .average()
    }

    @Benchmark
    fun productsListProcessing(): Double {
        return productsList
                .filter { it.adult }
                .flatMap { it.products }
                .filter { it.bought }
                .map { it.price }
                .average()
    }

    @Benchmark
    fun productsSequenceProcessing(): Double {
        return productsList.asSequence()
                .filter { it.adult }
                .flatMap { it.products.asSequence() }
                .filter { it.bought }
                .map { it.price }
                .average()
    }
}