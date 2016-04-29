package flowctrl.sample.common.web.search;

/**
 * Created by allbegray on 2016-04-29.
 */
public class TestSubSearchForm extends TestSearchForm {

    @Override
    public String getUri() {
        return "/test_sub";
    }

    @Queryable(defaultValue = "var2_default_value")
    private String var2;

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

}
