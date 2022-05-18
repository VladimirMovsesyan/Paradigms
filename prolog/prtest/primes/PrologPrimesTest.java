package prtest.primes;

import base.Selector;
import base.TestCounter;

import java.util.function.Consumer;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public final class PrologPrimesTest {
    public static final Selector SELECTOR = new Selector(PrologPrimesTest.class, "easy", "hard", "bonus")
            .variant("Primes", variant(t -> {}))
            ;

    private PrologPrimesTest() {
    }

    public static void main(final String... args) {
        SELECTOR.main(args);
    }

    /* package-private */ static Consumer<TestCounter> variant(final Consumer<PrologPrimesTester> check) {
        return counter -> {
            final int mode = counter.mode();
            final int max = (int) (1000 * Math.pow(100.0 / TestCounter.DENOMINATOR, mode));
            new PrologPrimesTester(counter, max, mode > 0, check).test();
        };
    }
}
