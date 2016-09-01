package allbegray.sample.common.excel;

import allbegray.sample.entity.Board;

/**
 * Created by allbegray on 2016-09-01.
 */
public class TestGridExcel extends AbstractGridExcel<Board> {

    private String param;

    public TestGridExcel(final String param) {
        super();
        this.param = param;
    }

    @Override
    protected void header() {
        System.out.println(param + "헤더 블라블라");
    }

    @Override
    public void addItem(Board item) {
        System.out.println("내용 블라블라");
    }

}
