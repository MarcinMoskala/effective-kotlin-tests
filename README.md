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
InlineFilterBenchmark.filterInline               avgt  200      36047.074 ±    443.227  ns/op
InlineFilterBenchmark.filterNoninline            avgt  200      41062.961 ±    358.404  ns/op
InlineRepeatBenchmark.repeatInline               avgt  200          0.308 ±      0.004  ns/op
InlineRepeatBenchmark.repeatNoninline            avgt  200  152452994.316 ± 448794.251  ns/op
PrimitiveArraysBenchmark.averageOnIntArray       avgt  200    1175822.925 ±   2887.306  ns/op
PrimitiveArraysBenchmark.averageOnIntList        avgt  200    1397573.292 ±  12593.957  ns/op
PrimitivesJavaBenchmark.objectCount10000         avgt  200      46337.847 ±    122.404  ns/op
PrimitivesJavaBenchmark.objectCount1_000_000     avgt  200    4715664.325 ±   8186.551  ns/op
PrimitivesJavaBenchmark.primitiveCount10_000     avgt  200          2.105 ±      0.009  ns/op
PrimitivesJavaBenchmark.primitiveCount1_000_000  avgt  200          2.094 ±      0.008  ns/op
SequancesBenchmark.productsListProcessing        avgt  200     681983.708 ±   1935.639  ns/op
SequancesBenchmark.productsSequenceProcessing    avgt  200     572329.151 ±  13552.228  ns/op
SequancesBenchmark.simpleListProcessing          avgt  200      15128.790 ±     60.219  ns/op
SequancesBenchmark.simpleSequenceProcessing      avgt  200       3448.715 ±     14.153  ns/op
SequancesBenchmark.singleStepListProcessing      avgt  200      31159.134 ±     89.067  ns/op
SequancesBenchmark.singleStepSequenceProcessing  avgt  200      33997.930 ±    194.029  ns/op
SequancesBenchmark.threeStepListProcessing       avgt  200      81264.772 ±    200.648  ns/op
SequancesBenchmark.threeStepSequenceProcessing   avgt  200       6854.901 ±     49.368  ns/op
SequancesBenchmark.twoStepListProcessing         avgt  200      78942.718 ±    179.537  ns/op
SequancesBenchmark.twoStepSequenceProcessing     avgt  200      53929.239 ±    206.061  ns/op
