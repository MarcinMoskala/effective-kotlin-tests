package org.kotlinacademy;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class PrimitivesJavaBenchmark {

    // 316594.815 ns/op
    @Benchmark
    public int primitiveCount1_000_000() {
        int a = 1;
        for (int i = 0; i < 1_000_000; i++) {
            a = a + i * 2;
        }
        return a;
    }

    // 4905603.432 ns/op
    @Benchmark
    public Integer objectCount1_000_000() {
        Integer a = 1;
        for (Integer i = 0; i < 1_000_000; i++) {
            a = a + i * 2;
        }
        return a;
    }

    // 3164.642 ns/op
    @Benchmark
    public int primitiveCount10_000() {
        int a = 1;
        for (int i = 0; i < 10_000; i++) {
            int b = 1;
            a = a + i * 2;
        }
        return a;
    }

    // 47454.720 ns/op
    @Benchmark
    public Integer objectCount10_000() {
        Integer a = 1;
        for (Integer i = 0; i < 10_000; i++) {
            a = a + i * 2;
        }
        return a;
    }
}
