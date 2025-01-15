package hanuri.website.controller;

import hanuri.website.domain.EBoardCategory;
import hanuri.website.domain.dto.Board.Board;
import hanuri.website.domain.dto.Member;
import hanuri.website.service.BoardService;
import hanuri.website.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {

    private final BoardService boardService;
    private final MemberService memberService;

    @Autowired
    public BoardController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @GetMapping("/board/new")
    public String newBoard(Model model, HttpSession session) {
        Board board = new Board();
        Member member = (Member) session.getAttribute("user");
        board.setMemberId(member.getMemberId());
        model.addAttribute("board", board);
        model.addAttribute("member", member);
        model.addAttribute("categorys", EBoardCategory.values());
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

    @GetMapping("/board/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Board board = boardService.findOne(id).orElseGet(Board::new);
        Member member = memberService.findOne(board.getMemberId()).orElseGet(Member::new);
        model.addAttribute("board", board);
        model.addAttribute("member", member);
        model.addAttribute("categorys", EBoardCategory.values());
        return "board/boardDetail";
    }

    @PostMapping("/board/modify")
    public String modify(@ModelAttribute Board board) {
        boardService.modify(board);
        return "redirect:/";
    }

}
