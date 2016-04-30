package flowctrl.sample.modules.global;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by allbegray on 2016-04-30.
 */
@Component
public class GlobalRequest {

    private ThreadLocal<Stack<String>> scripts = new ThreadLocal<Stack<String>>(){
        @Override
        protected Stack<String> initialValue() {
            return new Stack<>();
        }
    };

    public void pushScript(String script) {
        if (StringUtils.hasText(script))
            scripts.get().add(script);
    }

    public List<String> popScripts() {
        List<String> items = new ArrayList<>(scripts.get());
        scripts.remove();
        return items;
    }

}
