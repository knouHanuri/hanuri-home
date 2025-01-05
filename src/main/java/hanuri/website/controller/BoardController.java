package hanuri.website.controller;

import hanuri.website.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/new")
    public String newBoard(Model model) {
        return "board/boardNew";
    }

    @GetMapping("/board/list")
    public String board() {
        return "board/boardList";
    }
}
