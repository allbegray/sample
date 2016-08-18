package freemarker;

import allbegray.sample.common.freemarker.DynamicQuery;
import allbegray.sample.common.freemarker.FreemarkerSqlTemplate;
import allbegray.sample.common.freemarker.FreemarkerSqlTemplateFactory;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by allbegray on 2016-08-17.
 */
public class FreemarkerTest {

    public class SearchContext {
        private String name;
        private Integer age;
        private List<String> phones;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<String> getPhones() {
            return phones;
        }

        public void setPhones(List<String> phones) {
            this.phones = phones;
        }
    }

    @Test
    public void test() throws IOException, TemplateException {
        FreemarkerSqlTemplateFactory templateFactory = new FreemarkerSqlTemplateFactory();
        templateFactory.setDirectoryForTemplate(new ClassPathResource("/templates").getFile());
        FreemarkerSqlTemplate sqlTemplate = templateFactory.getObject();

        SearchContext sc = new SearchContext();
        sc.setName("하하하");
        sc.setAge(30);

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("searchContext", sc);

        DynamicQuery dynamicQuery = sqlTemplate.buildQuery("test", dataModel);
        System.out.println(dynamicQuery);
    }

}
