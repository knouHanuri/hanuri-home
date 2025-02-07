package hanuri.website.controller;

import hanuri.website.domain.EBoardCategory;
import hanuri.website.domain.dto.Board.Board;
import hanuri.website.domain.dto.Member;
import hanuri.website.dto.image.ImageDTO;
import hanuri.website.service.BoardService;
import hanuri.website.service.ImageService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final ImageService imageService;

    @Autowired  //생략 가능
    public BoardController(BoardService boardService, ImageService imageService) {
        this.boardService = boardService;
        this.imageService = imageService;
    }

    @GetMapping("/new")
    public String newBoard(Model model, HttpSession session) {
        Board board = new Board();
        Member member = (Member) session.getAttribute("user");
        board.setMemberId(member.getMemberId());
        model.addAttribute("board", board);
        model.addAttribute("member", member);
        model.addAttribute("categorys", EBoardCategory.values());
        return "board/boardNew";
    }

    @PostMapping("/new")
    public String saveBoard(@RequestParam MultipartFile[] files, @ModelAttribute Board board) throws IOException {
        // 게시판
        boardService.save(board);
        //이미지 파일 저장
        imageService.storeImages(files, board);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable int id, Model model) {
        Board board = boardService.findOne(id).orElseGet(Board::new);
        List<ImageDTO> imageList = imageService.findByObjectId(board);

        model.addAttribute("board", board);
        model.addAttribute("images", imageList);
        model.addAttribute("categorys", EBoardCategory.values());
        return "board/boardModify";
    }

    @PostMapping("/modify")
    public String modify(@RequestParam MultipartFile[] files, @ModelAttribute Board board) throws IOException {
        boardService.modify(board);
        imageService.modify(files, board);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Board board = boardService.findOne(id).orElseGet(Board::new);
        List<ImageDTO> imageList = imageService.findByObjectId(board);

        model.addAttribute("board", board);
        model.addAttribute("images", imageList);
        model.addAttribute("categorys", EBoardCategory.values());
        return "board/boardDetail";

    }

}
