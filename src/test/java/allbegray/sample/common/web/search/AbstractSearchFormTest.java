package allbegray.sample.common.web.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by allbegray on 2016-04-29.
 */
public class AbstractSearchFormTest {

    @Test
    public void userSearchTest() {
        TestUserSearchForm userSearchForm = new TestUserSearchForm();
        userSearchForm.setName("홍길동");
        userSearchForm.setPhone("010-1234-5678");
        userSearchForm.setAddress("이러군 망하리");
        Assert.assertEquals(userSearchForm.getQuery() , "/user/list?name=%ED%99%8D%EA%B8%B8%EB%8F%99&phone=010-1234-5678&address=%EC%9D%B4%EB%9F%AC%EA%B5%B0%20%EB%A7%9D%ED%95%98%EB%A6%AC&type=%EC%9D%BC%EB%B0%98%ED%9A%8C%EC%9B%90");
        Assert.assertEquals(userSearchForm.getRequestQuery() , "회원명:홍길동, 전화번호:010-1234-5678, 전화번호:이러군 망하리, 회원타입:일반회원");
    }

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
