package org.kotlinacademy;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class PrimitivesJavaBenchmark {

    // 0.330 ns/op
    @Benchmark
    public int primitiveCount1_000_000() {
        int a = 1;
        for (int i = 0; i < 1_000_000; i++) {
            int b = 1;
            a = a + b * 2;
        }
        return a;
    }

    // 5038300.166 ns/op
    @Benchmark
    public Integer objectCount1_000_000() {
        Integer a = 1;
        for (Integer i = 0; i < 1_000_000; i++) {
            Integer b = *1;
            a = a + b * 2;
        }
        return a;
    }

    // 0.300 ns/op
    @Benchmark
    public int primitiveCount10_000() {
        int a = 1;
        for (int i = 0; i < 10_000; i++) {
            int b = 1;
            a = a + b * 2;
        }
        return a;
    }

    // 52355.312 ns/op
    @Benchmark
    public Integer objectCount10000() {
        Integer a = 1;
        for (Integer i = 0; i < 10_000; i++) {
            Integer b = 1;
            a = a + b * 2;
        }
        return a;
    }
}
