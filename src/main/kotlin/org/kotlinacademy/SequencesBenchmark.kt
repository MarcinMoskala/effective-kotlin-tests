package org.kotlinacademy

import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit
import java.util.stream.Collectors

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
        productsList = List(5000) { Product(1.0 * (it % 1000) / 100, true) }
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
    fun productsStreamProcessing(): Double {
        return clientsList.stream()
                .filter { it.adult }
                .flatMap { it.products.stream() }
                .filter { it.bought }
                .mapToDouble { it.price }
                .average()
                .orElse(0.0)
    }

    @Benchmark
    fun singleStepListProcessing(): List<Product> {
        return productsList.filter { it.bought }
    }

    @Benchmark
    fun singleStepSequenceProcessing(): List<Product> {
        return productsList.asSequence()
                .filter { it.bought }
                .toList()
    }

    @Benchmark
    fun singleStepStreamProcessing(): List<Product> {
        return productsList.stream()
                .filter { it.bought }
                .collect(Collectors.toList())
    }

    @Benchmark
    fun twoStepListProcessing(): List<Double> {
        return productsList
                .filter { it.bought }
                .map { it.price }
    }

    @Benchmark
    fun twoStepSequenceProcessing(): List<Double> {
        return productsList.asSequence()
                .filter { it.bought }
                .map { it.price }
                .toList()
    }

    @Benchmark
    fun twoStepStreamProcessing(): List<Double> {
        return productsList.stream()
                .filter { it.bought }
                .map { it.price }
                .collect(Collectors.toList())
    }

    @Benchmark
    fun threeStepListProcessing(): Double {
        return productsList
                .filter { it.bought }
                .map { it.price }
                .average()
    }

    @Benchmark
    fun threeStepSequenceProcessing(): Double {
        return productsList.asSequence()
                .filter { it.bought }
                .map { it.price }
                .average()
    }

    @Benchmark
    fun threeStepStreamProcessing(): Double {
        return productsList.stream()
                .filter { it.bought }
                .mapToDouble { it.price }
                .average()
                .orElse(0.0)
    }

    @Benchmark
    fun productsSortAndProcessingList(): Double {
        return productsList
                .sortedBy { it.price }
                .filter { it.bought }
                .map { it.price }
                .average()
    }

    @Benchmark
    fun productsSortAndProcessingSequance(): Double {
        return productsList.asSequence()
                .sortedBy { it.price }
                .filter { it.bought }
                .map { it.price }
                .average()
    }

    @Benchmark
    fun productsSort(): List<Product> {
        return productsList.sortedBy { -it.price }
    }

    @Benchmark
    fun productsSequenceSort(): List<Product> {
        return productsList.asSequence()
                .sortedBy { -it.price }
                .toList()
    }

    @Benchmark
    fun productsCopyAndSort(): List<Product> {
        return productsList.toList().sortedBy { -it.price }
    }

    @Benchmark
    fun asSequenceToList(): List<Product> {
        return productsList.asSequence().toList()
    }

    @Benchmark
    fun copyList(): List<Product> {
        return productsList.toList()
    }

    @Benchmark
    fun productsSortAccumulate(): Double {
        return productsList.sortedBy { -it.price }
                .map { it.price }
                .average()
    }

    @Benchmark
    fun productsSequenceSortAccumulate(): Double {
        return productsList.asSequence()
                .sortedBy { -it.price }
                .map { it.price }
                .average()
    }
}