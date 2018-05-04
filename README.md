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

| Benchmark                                       | Mode | Cnt |         Score   |      Error | Units |
| ----------------------------------------------- | ---- | --- | --------------- | ---------- | ----- |
| InlineFilterBenchmark.filterInline              | avgt | 200 |     38175.602 ± |    577.725 | ns/op |
| InlineFilterBenchmark.filterNoninline           | avgt | 200 |     41211.566 ± |    318.711 | ns/op |
| InlineRepeatBenchmark.repeatInline              | avgt | 200 |         0.306 ± |      0.003 | ns/op |
| InlineRepeatBenchmark.repeatNoninline           | avgt | 200 | 156214223.616 ± | 444202.273 | ns/op |
| PrimitiveArraysBenchmark.averageOnIntArray      | avgt | 200 |   1198961.660 ± |   2420.378 | ns/op |
| PrimitiveArraysBenchmark.averageOnIntList       | avgt | 200 |   1439895.837 ± |  17428.123 | ns/op |
| PrimitivesJavaBenchmark.objectCount10000        | avgt | 200 |     47454.720 ± |     85.221 | ns/op |
| PrimitivesJavaBenchmark.objectCount1_000_000    | avgt | 200 |   4905603.432 ± |  15968.358 | ns/op |
| PrimitivesJavaBenchmark.primitiveCount10_000    | avgt | 200 |      3164.642 ± |      3.780 | ns/op |
| PrimitivesJavaBenchmark.primitiveCount1_000_000 | avgt | 200 |    316594.815 ± |    406.338 | ns/op |
| SequancesBenchmark.productsListProcessing       | avgt | 200 |    712434.095 ± |   3863.956 | ns/op |
| SequancesBenchmark.productsSequenceProcessing   | avgt | 200 |    572012.022 ± |  10992.150 | ns/op |
| SequancesBenchmark.simpleListProcessing         | avgt | 200 |     15190.734 ± |     61.496 | ns/op |
| SequancesBenchmark.simpleSequenceProcessing     | avgt | 200 |      3514.539 ± |      3.970 | ns/op |
| SequancesBenchmark.singleStepListProcessing     | avgt | 200 |     33811.473 ± |    278.746 | ns/op |
| SequancesBenchmark.singleStepSequenceProcessing | avgt | 200 |     35929.193 ± |    326.405 | ns/op |
| SequancesBenchmark.threeStepListProcessing      | avgt | 200 |     83307.285 ± |    206.103 | ns/op |
| SequancesBenchmark.threeStepSequenceProcessing  | avgt | 200 |      6928.032 ± |     39.900 | ns/op |
| SequancesBenchmark.twoStepListProcessing        | avgt | 200 |     81095.456 ± |    210.257 | ns/op |
| SequancesBenchmark.twoStepSequenceProcessing    | avgt | 200 |     55685.351 ± |    359.406 | ns/op |

