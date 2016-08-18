package allbegray.sample.common.freemarker.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

/**
 * Created by allbegray on 2016-08-18.
 */
public class WhereDirective implements TemplateDirectiveModel {

    public static String DIRECTIVE_NAME = "where";
    private static List<String> prefixesToOverride = Arrays.asList("AND ", "AND\n", "AND\n", "AND\t", "OR ", "OR\n", "OR\r", "OR\t");

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (body == null) {
            return;
        }
        StringWriter bodyWriter = new StringWriter();
        body.render(bodyWriter);

        Trim trim = new Trim();
        trim.setPrefix("WHERE");
        trim.setPrefixesToOverride(prefixesToOverride);
        String sql = trim.trim(bodyWriter.toString());

        Writer out = env.getOut();
        out.write(sql);
    }

}
