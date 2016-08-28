package allbegray.sample.module.board;

import allbegray.sample.dto.BoardDTO;
import allbegray.sample.entity.Board;
import allbegray.sample.web.board.BoardSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by allbegray on 2016-04-29.
 */
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Page<BoardDTO> findAllByContext(BoardSearchForm boardSearchForm, Pageable pageable) {
        return boardRepository.findAllByContext(boardSearchForm, pageable);
    }

    @Transactional
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Board findOne(Long id) {
        return boardRepository.findOne(id);
    }

}
