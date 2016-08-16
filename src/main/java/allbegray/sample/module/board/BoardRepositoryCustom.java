package allbegray.sample.module.board;

import allbegray.sample.dto.BoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by allbegray on 2016-08-16.
 */
public interface BoardRepositoryCustom {

    Page<BoardDTO> findAllByContext(Pageable pageable);

}
