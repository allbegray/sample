package flowctrl.sample.common.util.function;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t) throws Exception;
}
