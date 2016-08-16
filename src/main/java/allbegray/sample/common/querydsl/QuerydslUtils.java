package allbegray.sample.common.querydsl;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.SimpleExpression;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.StreamSupport;

/**
 * Created by allbegray on 2016-08-16.
 */
public class QuerydslUtils {

    public static OrderSpecifier[] orderSpecifiers(Sort sort, Function<? super String, ? extends SimpleExpression> function) {
        Optional<Sort> optional = Optional.ofNullable(sort);
        return optional.isPresent() ? StreamSupport.stream(optional.get().spliterator(), false)
                .filter(order -> order.getProperty() != null)
                .map(order -> new OrderSpecifier(Order.valueOf(order.getDirection().name()), function.apply(order.getProperty())))
                .toArray(OrderSpecifier[]::new) : null;
    }

}
