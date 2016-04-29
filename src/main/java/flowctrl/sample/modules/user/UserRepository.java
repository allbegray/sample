package flowctrl.sample.modules.user;

import flowctrl.sample.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by allbegray on 2016-04-29.
 */
public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User> {

    User findByLoginId(String loginId);

}
