package allbegray.sample.web.board;

import allbegray.sample.dto.BoardDTO;
import allbegray.sample.module.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by allbegray on 2016-08-16.
 */
@RestController
@RequestMapping("/rest/board")
class BoardRestController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/list", method = {GET, POST})
    public Page<BoardDTO> list(BoardSearchForm boardSearchForm, Pageable pageable, Model model) {
        return boardService.findAllByContext(boardSearchForm, pageable);
    }

}