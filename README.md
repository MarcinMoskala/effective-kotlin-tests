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
