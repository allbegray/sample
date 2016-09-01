package allbegray.sample.common.excel;

import org.junit.Test;

/**
 * Created by allbegray on 2016-09-01.
 */
public class AbstractGridExcelTest {

    @Test
    public void test() {
        TestGridExcel testGridExcel = new TestGridExcel("param");
        testGridExcel.addItem(null);
        testGridExcel.generator(null);
    }

}