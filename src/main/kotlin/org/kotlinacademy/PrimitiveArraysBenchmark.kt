package org.kotlinacademy

import org.openjdk.jmh.annotations.*
import java.util.concurrent.*
import java.util.concurrent.*
import java.util.ArrayList

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
open class PrimitiveArraysBenchmark {

    lateinit var list: List<Int>
    lateinit var array: IntArray

    @Setup
    fun init() {
        list = List(1_000_000) { it }
        array = IntArray(1_000_000) { it }
    }

    // 1 438 909 ns
    @Benchmark
    fun averageOnIntList(): Double {
        return list.average()
    }

    // 1 206 723 sn
    @Benchmark
    fun averageOnIntArray(): Double {
        return array.average()
    }
}