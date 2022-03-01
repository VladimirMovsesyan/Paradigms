package queue;

import base.Selector;
import base.TestCounter;
import queue.Queues.QueueChecker;
import queue.Queues.QueueModel;

import java.util.ArrayDeque;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public final class QueueTest {
    // === Functions

    /* package-private */  interface FunctionsModel extends Queues.QueueModel {
        @ReflectionTest.Wrap
        default FunctionsModel filter(final Predicate<Object> p) {
            return apply(Stream::filter, p);
        }

        @ReflectionTest.Wrap
        default FunctionsModel map(final Function<Object, Object> f) {
            return apply(Stream::map, f);
        }

        private <T> FunctionsModel apply(final BiFunction<Stream<Object>, T, Stream<Object>> f, final T v) {
            final ArrayDeque<Object> deque = f.apply(model().stream(), v).collect(Collectors.toCollection(ArrayDeque::new));
            return () -> deque;
        }
    }

    /* package-private */ static final Queues.Splitter<FunctionsModel> FUNCTIONS = (tester, queue, random) -> {
        final FunctionsModel result = random.nextBoolean()
                                                 ? queue.filter(Predicate.isEqual(tester.randomElement(random)))
                                                 : queue.map(random.nextBoolean() ? String::valueOf : Object::hashCode);
        return List.of(tester.cast(result));
    };

    public static final Selector SELECTOR = new Selector(QueueTest.class)
            .variant("Base", variant(QueueModel.class, d -> () -> d))
            .variant("Functions", variant(FunctionsModel.class, d -> () -> d, FUNCTIONS))
            ;

    private QueueTest() {
    }

    public static void main(final String... args) {
        SELECTOR.main(args);
    }

    /* package-private */ static <M extends QueueModel, T extends QueueChecker<M>> Consumer<TestCounter> variant(
            final Class<M> type,
            final T tester,
            final Queues.Splitter<M> splitter
    ) {
        return new QueueTester<>(type, tester, splitter)::test;
    }

    /* package-private */ public static <M extends QueueModel, T extends QueueChecker<M>> Consumer<TestCounter> variant(
            final Class<M> type,
            final T tester
    ) {
        return variant(type, tester, (t, q, r) -> List.of());
    }
}
