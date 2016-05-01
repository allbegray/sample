package flowctrl.sample.modules.global;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

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

    private void removeContext(String key) {
        context.get().remove(key);
    }

    private Stack<String> getScripts() {
        Stack<String> stack = (Stack<String>) context.get().get(G_SCRIPT_TAG);
        if (stack == null) {
            stack = new Stack<>();
            context.get().put(G_SCRIPT_TAG, stack);
        }
        return stack;
    }

    public void pushScript(String script) {
        if (StringUtils.hasText(script))
            getScripts().add(script);
    }

    public List<String> popScripts() {
        List<String> items = new ArrayList<>(getScripts());
        removeContext(G_SCRIPT_TAG);
        return items;
    }

}
