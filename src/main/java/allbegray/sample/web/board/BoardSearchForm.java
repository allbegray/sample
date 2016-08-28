package allbegray.sample.web.board;

import allbegray.sample.common.web.search.AbstractSearchForm;
import allbegray.sample.common.web.search.Queryable;

/**
 * Created by allbegray on 2016-08-28.
 */
public class BoardSearchForm extends AbstractSearchForm {

    @Queryable
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getUri() {
        return "/board/page";
    }

}
