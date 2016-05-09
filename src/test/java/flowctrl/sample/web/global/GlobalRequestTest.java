package flowctrl.sample.web.global;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by allbegray on 2016-04-30.
 */
public class GlobalRequestTest {

    @Test
    public void scriptsTest() {
        GlobalRequest g = new GlobalRequest();
        g.pushScript("1");
        g.pushScript("2");
        Assert.assertTrue(g.popScripts().size() == 2);

        g.pushScript("3");
        Assert.assertTrue(g.popScripts().size() == 1);
    }

}