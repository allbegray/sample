package flowctrl.sample.modules.global;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by allbegray on 2016-04-30.
 */
@Component
public class GlobalRequest {

    private ThreadLocal<Stack<String>> scripts = new ThreadLocal<>();

    public Stack<String> getScripts() {
        Stack<String> stack = scripts.get();
        if (stack == null) {
            stack = new Stack<>();
            scripts.set(stack);
        }
        return stack;
    }

    public void pushScript(String script) {
        getScripts().add(script);
    }

    public List<String> popScripts() {
        List<String> items = new ArrayList<>(getScripts());
        scripts.remove();
        return items;
    }

}
