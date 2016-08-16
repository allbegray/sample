package allbegray.sample.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by allbegray on 2016-04-29.
 */
@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping(value = {"", "/", "index"}, method = {GET, POST})
    public String index() {
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/list", method = {GET, POST})
    public String list() {
        return "board/list";
    }

}
