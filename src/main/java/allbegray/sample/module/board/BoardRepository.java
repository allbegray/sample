package allbegray.sample.module.board;

import allbegray.sample.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by allbegray on 2016-04-29.
 */
public interface BoardRepository extends JpaRepository<Board, Long>, QueryDslPredicateExecutor<Board>, BoardRepositoryCustom {

}
