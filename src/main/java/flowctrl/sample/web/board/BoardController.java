package flowctrl.sample.web.board;

import flowctrl.sample.entity.Board;
import flowctrl.sample.module.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by allbegray on 2016-04-29.
 */
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Page<Board> list(Pageable pageable) {
        Page<Board> page = boardService.findAll(pageable);
        return page;
    }

}
