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

    @GetMapping("/home")
    public String home(Model model) {
        //default 공지사항
        int categoryId = EBoardCategory.info.getValue();
        List<Board> boardList = boardService.findWithCategory(categoryId);
        model.addAttribute("categories", EBoardCategory.values());
        model.addAttribute("selectedCategory", EBoardCategory.getDisplayNameAndValue(categoryId));
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }

    @GetMapping("/new/{categoryId}")
    public String newBoard(@PathVariable int categoryId, Model model, HttpSession session) throws Exception {
        Board board = new Board();

        if(session.getAttribute("user") != null) {
            Member member = (Member) session.getAttribute("user");
            board.setMemberId(member.getMemberId());
            model.addAttribute("board", board);
            model.addAttribute("member", member);
            model.addAttribute("categories", EBoardCategory.values());
            model.addAttribute("selectedCategory", EBoardCategory.getDisplayNameAndValue(categoryId));
        }else{
            throw new Exception("세션없음");
        }
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

    @GetMapping("/list/{categoryId}")
    public String list(@PathVariable int categoryId, Model model) {
        List<Board> boardList = boardService.findWithCategory(categoryId);
        model.addAttribute("categories", EBoardCategory.values());
        model.addAttribute("selectedCategory", EBoardCategory.getDisplayNameAndValue(categoryId));

        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model) {
        Board board = boardService.findOne(id).orElseGet(Board::new);
        List<ImageDTO> imageList = imageService.findByObjectId(board);
        model.addAttribute("board", board);
        model.addAttribute("images", imageList);
        model.addAttribute("categories", EBoardCategory.values());
        return "board/boardModify";
    }

    @PostMapping("/modify")
    public String modify(@RequestParam MultipartFile[] files, @ModelAttribute Board board) throws IOException {
        boardService.modify(board);
        imageService.modifyImages(files, board);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Board board = boardService.findOne(id).orElseGet(Board::new);
        List<ImageDTO> imageList = imageService.findByObjectId(board);

        model.addAttribute("board", board);
        model.addAttribute("images", imageList);
        model.addAttribute("categories", EBoardCategory.values());
        return "board/boardDetail";

    }

}
