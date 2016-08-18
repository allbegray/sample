package allbegray.sample.common.freemarker.method;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by allbegray on 2016-08-18.
 */
public class ParamMethod implements TemplateMethodModelEx {

    private boolean withPositionalIndex = false;
    private int index = 1;
    private List<Object> params = new ArrayList<>();

    public List<Object> getParams() {
        return Collections.unmodifiableList(params);
    }

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (arguments == null || arguments.size() != 1) {
            throw new TemplateModelException("인자가 부족합니다.");
        }

        params.add(arguments.get(0));
        return withPositionalIndex ? "?" : "?" + (index++);
    }

}