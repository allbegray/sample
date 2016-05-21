package allbegray.sample.module.board;

import allbegray.sample.entity.Board;
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
    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

}
