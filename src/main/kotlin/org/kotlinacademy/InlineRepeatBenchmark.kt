package org.kotlinacademy

import org.openjdk.jmh.annotations.*
import java.util.concurrent.*
import java.util.*
import java.util.concurrent.TimeUnit

inline fun inlineRepeat(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

fun noinlineRepeat(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
open class InlineRepeatBenchmark {

    @Benchmark
    fun repeatInline() {
        var a = 2L
        inlineRepeat(100_000_000) {
            a += a / 2
        }
    }

    @Benchmark
    fun repeatNoninline() {
        var a = 2L
        noinlineRepeat(100_000_000) {
            a += a / 2
        }
    }
}