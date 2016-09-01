package allbegray.sample.common.jooq;

import org.jooq.Field;
import org.jooq.SortField;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by allbegray on 2016-09-01.
 */
public class JooqUtils {

    /**
     * order 절에 사용될 정렬 필드 생성. 타입 세이프 하지는 않다.
     * @param sortSpecification
     * @return
     */
    public static Collection<SortField<?>> orderSpecifiers(Sort sortSpecification) {
        Collection<SortField<?>> querySortFields = new ArrayList<>();

        if (sortSpecification == null) {
            return querySortFields;
        }

        Iterator<Sort.Order> specifiedFields = sortSpecification.iterator();

        while (specifiedFields.hasNext()) {
            Sort.Order specifiedField = specifiedFields.next();

            String sortFieldName = specifiedField.getProperty();
            Sort.Direction sortDirection = specifiedField.getDirection();

            Field<?> field = DSL.field(sortFieldName);
            SortField<?> querySortField = sortDirection == Sort.Direction.ASC ? field.asc() : field.desc();
            querySortFields.add(querySortField);
        }

        return querySortFields;
    }

}
