package flowctrl.sample.common.util.function;

@FunctionalInterface
public interface Supplier<T> {
    T get() throws Exception;
}
