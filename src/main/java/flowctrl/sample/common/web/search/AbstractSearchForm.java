package flowctrl.sample.common.web.search;

import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by allbegray on 2016-04-29.
 */
public abstract class AbstractSearchForm {

    public abstract String getUri();

    private List<Parameter> makeParameters() {
        List<Parameter> parameters = new ArrayList<>();
        Class<?> clazz = this.getClass();
        while (true) {
            final Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Queryable annotation = field.getAnnotation(Queryable.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(this);
                        parameters.add(new Parameter(field.getName(), value != null ? value : annotation.defaultValue(), annotation.name()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (clazz == AbstractSearchForm.class)
                break;
            else
                clazz = clazz.getSuperclass();
        }
        return parameters;
    }

    public String getRequestQuery() {
        StringBuffer result = new StringBuffer("");
        for (Parameter param : makeParameters()) {
            if (result.length() > 0) result.append(", ");
            result.append(param.getName()).append(":").append(param.getValue());
        }
        return result.toString();
    }

    public String getQuery() {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        try {
            if (getUri() != null) {
                builder.uri(new URI(getUri()));
            }
            for (Parameter param : makeParameters()) {
                builder.queryParam(param.getField(), param.getValue());
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return builder.toUriString();
    }

}
