package base;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 5)
@Fork(1)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class TestCasAndSync {

    @Param(value = {"1000000", "10000000"})
    private int loop;

    TestSynchronized testSynchronized = new TestSynchronized();
    TestCas testCas = new TestCas();

    @Threads(6)
    @Benchmark
    public void testCAS() {
        testCas.add(loop);

    }

    @Threads(6)
    @Benchmark
    public void testSynchronized() {
        testSynchronized.add(loop);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CASTest.class.getSimpleName())
                .result("result.json")
                .resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }


}
