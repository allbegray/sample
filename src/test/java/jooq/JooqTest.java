package jooq;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static allbegray.sample.common.jooq.JooqUtils.orderSpecifiers;

/**
 * Created by allbegray on 2016-09-01.
 */
public class JooqTest {

    DSLContext create = null;
    Connection conn = null;

    @Before
    public void setup() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:file:~/testdb", "sa", null);
        create = DSL.using(conn, SQLDialect.H2);
    }

    @After
    public void shutdown() throws SQLException {
        conn.close();
    }

    @Test
    public void test() throws SQLException {
        PageRequest pageRequest = new PageRequest(0, 10, Sort.Direction.DESC, "title");

        SelectConditionStep<Record> query = create.select().from(DSL.table("board")).where(DSL.field("title", String.class).like("제목%"));
        query.orderBy(orderSpecifiers(pageRequest.getSort()));

        create.fetchCount(query);
        query.fetch();
    }

}
