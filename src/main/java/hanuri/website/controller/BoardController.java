package hanuri.website.controller;

import hanuri.website.domain.dto.Board.Board;
import hanuri.website.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/new")
    public String newBoard(Model model) {
        model.addAttribute("board", new Board());
        return "board/boardNew";
    }

    @PostMapping("/board/new")
    public String saveBoard(@ModelAttribute Board board) {
        boardService.save(board);
        return "redirect:/";
    }

    @GetMapping("/board/list")
    public String list(Model model) {
        List<Board> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }
}
