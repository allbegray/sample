package flowctrl.sample.modules.global;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by allbegray on 2016-04-30.
 */
@Component
public class GlobalRequest {

    private final static String G_SCRIPT_TAG = "G_SCRIPT_TAG";

    private ThreadLocal<Map<String, Object>> context = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    private <T> T getContext(String key, Supplier<T> supplier) {
        T t = (T) context.get().get(key);
        if (t == null) {
            t = supplier.get();
            context.get().put(key, t);
        }
        return t;
    }

    private <T> T popContext(String key, Supplier<T> supplier) {
        T t = (T) context.get().get(key);
        if (t != null) {
            context.get().remove(key);
        }
        return t;
    }

    public void pushScript(String script) {
        if (StringUtils.hasText(script))
            getContext(G_SCRIPT_TAG, Stack::new).add(script);
    }

    public List<String> popScripts() {
        return new ArrayList<>(popContext(G_SCRIPT_TAG, Stack::new));
    }

}
