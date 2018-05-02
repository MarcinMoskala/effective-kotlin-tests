package org.kotlinacademy

import org.openjdk.jmh.annotations.*
import java.util.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
open class SequancesBenchmark {

    lateinit var clientsList: List<Client>
    lateinit var productsList: List<Product>

    @Setup
    fun init() {
        clientsList = List(1000) {
            Client(
                    adult = it % 10 != 1,
                    products = List(50) { Product(1.0 * it / 100, true) }
            )
        }
        productsList = List(5000) { Product(1.0 * it / 100, true) }
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
        return clientsList
                .filter { it.adult }
                .flatMap { it.products }
                .filter { it.bought }
                .map { it.price }
                .average()
    }

    @Benchmark
    fun productsSequenceProcessing(): Double {
        return clientsList.asSequence()
                .filter { it.adult }
                .flatMap { it.products.asSequence() }
                .filter { it.bought }
                .map { it.price }
                .average()
    }

    @Benchmark
    fun singleStepSequenceProcessing(): List<Product> {
        return productsList.asSequence()
                .filter { it.bought }
                .toList()
    }

    @Benchmark
    fun singleStepListProcessing(): List<Product> {
        return productsList.filter { it.bought }
    }

    @Benchmark
    fun twoStepSequenceProcessing(): List<Double> {
        return productsList.asSequence()
                .filter { it.bought }
                .map { it.price }
                .toList()
    }

    @Benchmark
    fun twoStepListProcessing(): List<Double> {
        return productsList
                .filter { it.bought }
                .map { it.price }
    }

    @Benchmark
    fun threeStepSequenceProcessing(): Double {
        return productsList.asSequence()
                .filter { it.bought }
                .map { it.price }
                .average()
    }

    @Benchmark
    fun threeStepListProcessing(): Double {
        return productsList
                .filter { it.bought }
                .map { it.price }
                .average()
    }
}