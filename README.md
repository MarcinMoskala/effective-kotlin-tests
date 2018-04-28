Based on kotlin-benchmarks [kotlin-benchmarks](https://github.com/JetBrains/kotlin-benchmarks)

A set of JMH benchmarks for various Kotlin language constructions and standard library functions.

Build:
```
mvn clean package
```

Note: need clean package every time, otherwise removed benchmarks will be hanging around.

Run:
```
java -jar target/benchmarks.jar
```

Also see commands.txt for more pre-configured commands.

# Last results:

Benchmark                                        Mode  Cnt          Score        Error  Units
InlineFilterBenchmark.filterNoninline           avgt  200      41062.961 ±    358.404  ns/op
InlineFilterBenchmark.filterInline               avgt  200      36047.074 ±    443.227  ns/op
InlineRepeatBenchmark.repeatInline               avgt  200          0.304 ±      0.003  ns/op
InlineRepeatBenchmark.repeatNoninline            avgt  200  153980484.884 ± 712958.682  ns/op
PrimitiveArraysBenchmark.averageOnIntArray       avgt  200    1187058.159 ±   1168.183  ns/op
PrimitiveArraysBenchmark.averageOnIntList        avgt  200    1406471.458 ±   9809.722  ns/op
PrimitivesJavaBenchmark.objectCount10000         avgt  200      46685.510 ±     47.954  ns/op
PrimitivesJavaBenchmark.objectCount1_000_000     avgt  200    4762432.028 ±   4294.221  ns/op
PrimitivesJavaBenchmark.primitiveCount10_000     avgt  200          2.146 ±      0.008  ns/op
PrimitivesJavaBenchmark.primitiveCount1_000_000  avgt  200          2.127 ±      0.012  ns/op
