package allbegray.sample.common.freemarker;

import java.util.List;

/**
 * Created by allbegray on 2016-08-19.
 */
public class DynamicQuery {

    private String sql;
    private List<Object> parameters;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<Object> getParameters() {
        return parameters;
    }

    public void setParameters(List<Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SQL 쿼리 :\n").append(sql).append("\n");
        sb.append("파라미터 :\n").append(parameters).append("\n");
        return sb.toString();
    }

}
