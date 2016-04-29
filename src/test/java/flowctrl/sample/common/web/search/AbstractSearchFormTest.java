package flowctrl.sample.common.web.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by allbegray on 2016-04-29.
 */
public class AbstractSearchFormTest {

    @Test
    public void basicTest() {
        TestSubSearchForm searchForm = new TestSubSearchForm();
        Assert.assertEquals(searchForm.getQuery() , "/test_sub?var2=var2_default_value&var1=");
    }

    @Test
    public void noUriTest() {
        TestSearchForm searchForm1 = new TestSearchForm();
        searchForm1.setNonVar("test");
        searchForm1.setVar1("value1");
        Assert.assertEquals(searchForm1.getQuery(), "?var1=value1");
    }

}
