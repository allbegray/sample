package allbegray.sample.web.board;

import allbegray.sample.common.spring.PageWrapper;
import allbegray.sample.dto.BoardDTO;
import allbegray.sample.entity.Board;
import allbegray.sample.module.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by allbegray on 2016-04-29.
 */
@Controller
@RequestMapping("/board")
@SessionAttributes("boardForm")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setAllowedFields("title", "content");
    }

    @RequestMapping(value = "/page")
    public String page(Pageable pageable, Model model) {

//        for (int i = 0; i < 100; i++) {
//            Board board = new Board();
//            board.setTitle("제목" + (i + 1));
//            board.setContent("내용" + (i + 1));
//            boardService.save(board);
//        }

        Page<BoardDTO> page = boardService.findAllByContext(pageable);
        model.addAttribute("page", new PageWrapper<>(page));
        return "board/page";
    }

    @RequestMapping(value = {"", "/", "index"}, method = GET)
    public String index() {
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/list", method = {GET, POST})
    public String list() {
        return "board/list";
    }

    @RequestMapping(value = "/add", method = GET)
    public String addForm(Model model) {
        model.addAttribute("boardForm", new Board());
        return "board/form";
    }

    @RequestMapping(value = "/update/{id}", method = GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("boardForm", boardService.findOne(id));
        return "board/form";
    }

    @RequestMapping(method = POST)
    public String save(@Valid @ModelAttribute("boardForm") Board board, BindingResult bindingResult, SessionStatus sessionStatus, Model model) {
        if (bindingResult.hasErrors()) {
            return "board/form";
        } else {
            boardService.save(board);
            sessionStatus.setComplete();
            return "redirect:/board/" + board.getId();
        }
    }

    @RequestMapping(value = "/{id}", method = GET)
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("board", boardService.findOne(id));
        return "board/view";
    }

}
