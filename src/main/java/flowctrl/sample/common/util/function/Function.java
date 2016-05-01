package flowctrl.sample.common.util.function;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t) throws Exception;
}