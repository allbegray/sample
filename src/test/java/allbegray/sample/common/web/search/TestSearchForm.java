package allbegray.sample.common.web.search;

/**
 * Created by allbegray on 2016-04-29.
 */
public class TestSearchForm extends AbstractSearchForm {

    @Queryable
    private String var1;

    private String nonVar;

    public String getNonVar() {
        return nonVar;
    }

    public void setNonVar(String nonVar) {
        this.nonVar = nonVar;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    @Override
    public String getUri() {
        return null;
    }

}
