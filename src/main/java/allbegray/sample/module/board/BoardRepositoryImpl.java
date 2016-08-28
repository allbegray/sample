package allbegray.sample.module.board;

import allbegray.sample.dto.BoardDTO;
import allbegray.sample.entity.Board;
import allbegray.sample.entity.QBoard;
import allbegray.sample.web.board.BoardSearchForm;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import static allbegray.sample.common.querydsl.QuerydslUtils.orderSpecifiers;

/**
 * Created by allbegray on 2016-08-16.
 */
@Repository
public class BoardRepositoryImpl extends QueryDslRepositorySupport implements BoardRepositoryCustom  {

    public BoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Page<BoardDTO> findAllByContext(BoardSearchForm boardSearchForm, Pageable pageable) {
        QBoard board = new QBoard("n");

        BooleanExpression titleLikeExpression = null;
        if (StringUtils.hasText(boardSearchForm.getTitle())) {
            titleLikeExpression = board.title.like("%" + boardSearchForm.getTitle() + "%");
        }

        QBean<BoardDTO> qBean = Projections.bean(BoardDTO.class,
                board.id,
                board.title,
                board.content,
                board.updatedAt.as("date"));

        QueryResults<BoardDTO> queryResults = from(board)
                .select(qBean)
                .where(titleLikeExpression)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(
                        orderSpecifiers(pageable.getSort(), field -> {
                            switch (field) {
                                case "id":
                                    return board.id;
                                case "title":
                                    return board.title;
                                case "content":
                                    return board.content;
                                case "date":
                                    return board.updatedAt;
                            }
                            return null;
                        }, board.updatedAt.desc())
                )
                .fetchResults();

        return new PageImpl<>(queryResults.getResults(), pageable, queryResults.getTotal());
    }

}
