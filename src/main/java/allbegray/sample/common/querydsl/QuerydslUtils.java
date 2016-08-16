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

    public static OrderSpecifier[] orderSpecifiers(Sort sort, Function<? super String, ? extends SimpleExpression> function, OrderSpecifier<?> defaultOrder) {
        Optional<Sort> optional = Optional.ofNullable(sort);
        return optional.isPresent() ? StreamSupport.stream(optional.get().spliterator(), false)
                .filter(order -> order.getProperty() != null)
                .map(order -> {
                    SimpleExpression expression = function.apply(order.getProperty());
                    if (expression == null) {
                        throw new NullPointerException("정렬 필드(" + order.getProperty() + ") 에 해당하는 컬럼을 찾을 수 없습니다.");
                    }
                    return new OrderSpecifier(Order.valueOf(order.getDirection().name()), expression);
                })
                .toArray(OrderSpecifier[]::new) : (defaultOrder != null ? new OrderSpecifier[]{defaultOrder} : null);
    }

}
