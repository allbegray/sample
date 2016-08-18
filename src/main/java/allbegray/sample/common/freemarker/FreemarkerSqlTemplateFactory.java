package allbegray.sample.common.freemarker;

import allbegray.sample.common.freemarker.directive.WhereDirective;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

/**
 * Created by allbegray on 2016-08-19.
 */
public class FreemarkerSqlTemplateFactory {

    public static String DEFAULT_DIRECTIVE_PREFIX = "";
    public static String DEFAULT_PARAM_METHOD_NAME = "param";
    public static String DEFAULT_TEMPLATE_NAME_SUFFIX = ".ftl";
    public static String DEFAULT_ENCODING = "UTF-8";

    private String directivePrefix = DEFAULT_DIRECTIVE_PREFIX;
    private String paramMethodName = DEFAULT_PARAM_METHOD_NAME;
    private String templateNameSuffix = DEFAULT_TEMPLATE_NAME_SUFFIX;
    private String encoding = DEFAULT_ENCODING;
    private File directoryForTemplate;

    public void setDirectivePrefix(String directivePrefix) {
        this.directivePrefix = directivePrefix;
    }

    public void setParamMethodName(String paramMethodName) {
        this.paramMethodName = paramMethodName;
    }

    public void setTemplateNameSuffix(String templateNameSuffix) {
        this.templateNameSuffix = templateNameSuffix;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setDirectoryForTemplate(File directoryForTemplate) {
        this.directoryForTemplate = directoryForTemplate;
    }

    public FreemarkerSqlTemplate getObject() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        try {
            cfg.setDirectoryForTemplateLoading(directoryForTemplate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cfg.setDefaultEncoding(encoding);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        cfg.setSharedVariable(directivePrefix + WhereDirective.DIRECTIVE_NAME, new WhereDirective());

        FreemarkerSqlTemplate template = new FreemarkerSqlTemplate();
        template.setCfg(cfg);
        template.setParamMethodName(paramMethodName);
        template.setTemplateNameSuffix(templateNameSuffix);
        return template;
    }

}
