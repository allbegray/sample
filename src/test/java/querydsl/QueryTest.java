package querydsl;

import allbegray.sample.entity.QBoard;
import allbegray.sample.entity.QUser;
import com.querydsl.jpa.JPQLQuery;
import org.junit.Test;

import static com.querydsl.jpa.JPAExpressions.select;

/**
 * Created by allbegray on 2016-08-17.
 */
public class QueryTest {

    @Test
    public void test() {
        QBoard b = new QBoard("b");
        QUser u = new QUser("u");

        JPQLQuery<String> query1 = select(b.title).from(b);
        System.out.println(query1);

        JPQLQuery<String> query2 = select(u.name).from(u);
        System.out.println(query2);
    }

}
