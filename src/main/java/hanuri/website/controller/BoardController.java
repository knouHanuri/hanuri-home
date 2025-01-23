package hanuri.website.controller;

import hanuri.website.domain.EBoardCategory;
import hanuri.website.domain.dto.Board.Board;
import hanuri.website.domain.dto.Member;
import hanuri.website.dto.image.EImageType;
import hanuri.website.dto.image.ImageDTO;
import hanuri.website.dto.image.ImageRequestDTO;
import hanuri.website.service.BoardService;
import hanuri.website.service.ImageService;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class BoardController {

    private final BoardService boardService;
    private final MemberService memberService;
    private final ImageService imageService;

    @Autowired
    public BoardController(BoardService boardService, MemberService memberService, ImageService imageService) {
        this.boardService = boardService;
        this.memberService = memberService;
        this.imageService = imageService;
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
    public String saveBoard(MultipartFile[] files, @ModelAttribute Board board) {

        boardService.save(board);
        for (MultipartFile file : files) {
            try {
                String fileName = file.getOriginalFilename();
                assert fileName != null;
                String ext = fileName.substring(fileName.lastIndexOf("."));
                String newFileName = UUID.randomUUID().toString() + ext;

                Path folderPath = Paths.get("D:\\hanuri\\" + EImageType.board);
                Path filePath = folderPath.resolve(newFileName);

                if(!Files.exists(folderPath)) {
                    Files.createDirectories(folderPath);
                }
                byte[] arr = file.getBytes();
                Files.write(filePath, arr);

                ImageDTO imageDTO = new ImageDTO();
                imageDTO.setImageType(EImageType.board);
                imageDTO.setObjectId(board.getBoardId());
                imageDTO.setFilePath(filePath.toString());
                imageDTO.setFileName(fileName);
                imageDTO.setExtension(ext);
                imageDTO.setNewFileName(newFileName);
                imageService.save(imageDTO);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
        ImageRequestDTO imageRequestDTO = new ImageRequestDTO(EImageType.board,board.getBoardId());
        List<ImageDTO> imageList = imageService.findByObjectId(imageRequestDTO);
        model.addAttribute("board", board);
        model.addAttribute("images", imageList);
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
