## Original
Benchmark                                       Mode   Cnt    Score    Error   Units
TopKBenchmark.benchmarkCalculateTopK           thrpt    25    0.004 ±  0.001  ops/ms
TopKBenchmark.benchmarkCalculateTopK            avgt    25  246.100 ±  3.351   ms/op
TopKBenchmark.benchmarkCalculateTopK          sample  1003  251.652 ±  3.131   ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.00    sample        213.910            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.50    sample        240.124            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.90    sample        296.223            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.95    sample        313.524            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.99    sample        351.609            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.999   sample        434.029            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.9999  sample        434.110            ms/op
TopKBenchmark.benchmarkCalculateTopK:p1.00    sample        434.110            ms/op
TopKBenchmark.benchmarkCalculateTopK              ss     5  333.508 ± 55.024   ms/op

## Improved by DeepSeek
Benchmark                                       Mode    Cnt   Score   Error   Units
TopKBenchmark.benchmarkCalculateTopK           thrpt     25   0.276 ± 0.042  ops/ms
TopKBenchmark.benchmarkCalculateTopK            avgt     25   4.062 ± 0.441   ms/op
TopKBenchmark.benchmarkCalculateTopK          sample  60889   4.104 ± 0.010   ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.00    sample          3.604           ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.50    sample          4.182           ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.90    sample          4.227           ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.95    sample          4.309           ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.99    sample          4.792           ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.999   sample          5.366           ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.9999  sample         54.112           ms/op
TopKBenchmark.benchmarkCalculateTopK:p1.00    sample         99.877           ms/op
TopKBenchmark.benchmarkCalculateTopK              ss      5  17.988 ± 1.378   ms/op

## Improved by developer
Benchmark                                       Mode    Cnt   Score    Error   Units
TopKBenchmark.benchmarkCalculateTopK           thrpt     25   0.306 ±  0.015  ops/ms
TopKBenchmark.benchmarkCalculateTopK            avgt     25   3.123 ±  0.302   ms/op
TopKBenchmark.benchmarkCalculateTopK          sample  76605   3.262 ±  0.008   ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.00    sample          2.806            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.50    sample          3.318            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.90    sample          3.396            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.95    sample          3.514            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.99    sample          3.908            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.999   sample          4.563            ms/op
TopKBenchmark.benchmarkCalculateTopK:p0.9999  sample         46.399            ms/op
TopKBenchmark.benchmarkCalculateTopK:p1.00    sample         82.838            ms/op
TopKBenchmark.benchmarkCalculateTopK              ss      5  18.345 ± 11.697   ms/op