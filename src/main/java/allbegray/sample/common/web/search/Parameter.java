package allbegray.sample.common.web.search;

/**
 * Created by allbegray on 2016-04-29.
 */
public class Parameter {

    private String field;
    private Object value;
    private String name;

    public Parameter() {
    }

    public Parameter(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public Parameter(String field, Object value, String name) {
        this.field = field;
        this.value = value;
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
