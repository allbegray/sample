package allbegray.sample.common.freemarker;

import allbegray.sample.common.freemarker.method.ParamMethod;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allbegray on 2016-08-19.
 */
public class FreemarkerSqlTemplate {

    private Configuration cfg;
    private String paramMethodName;
    private String templateNameSuffix;

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }

    public void setParamMethodName(String paramMethodName) {
        this.paramMethodName = paramMethodName;
    }

    public void setTemplateNameSuffix(String templateNameSuffix) {
        this.templateNameSuffix = templateNameSuffix;
    }

    protected FreemarkerSqlTemplate() {
    }

    public DynamicQuery buildQuery(String templateName, Map<String, Object> dataModel) {
        try {
            final Map<String, Object> finalDataModel = new HashMap<>(dataModel);
            ParamMethod paramMethod = new ParamMethod();
            finalDataModel.put(paramMethodName, paramMethod);

            Template template = cfg.getTemplate(templateName + templateNameSuffix);
            StringWriter writer = new StringWriter();
            template.process(finalDataModel, writer);

            DynamicQuery dynamicQuery = new DynamicQuery();
            dynamicQuery.setSql(writer.toString());
            dynamicQuery.setParameters(paramMethod.getParams());
            return dynamicQuery;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

}
