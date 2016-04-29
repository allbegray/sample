package flowctrl.sample.common.web.search;

import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allbegray on 2016-04-29.
 */
public abstract class AbstractSearchForm {

    public abstract String uri();

    private Map<String, Object> createParameter() {
        Map<String, Object> params = new HashMap<>();
        Class<?> clazz =  this.getClass();
        while (true) {
            final Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Queryable annotation = field.getAnnotation(Queryable.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(this);
                        params.put(field.getName(), value != null ? value : annotation.defaultValue());
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
        return params;
    }

    public String getQuery() {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        try {
            if (uri() != null) {
                builder.uri(new URI(uri()));
            }
            for (Map.Entry<String, Object> param : createParameter().entrySet()) {
                builder.queryParam(param.getKey(), param.getValue());
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return builder.toUriString();
    }

}
