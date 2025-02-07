package hanuri.website.controller;


import hanuri.website.domain.dto.Board.Board;
import hanuri.website.dto.Study;
import hanuri.website.service.BoardService;
import hanuri.website.service.StudyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {

    private final StudyService studyService;
    private final BoardService boardService;

    @Autowired  //생략 가능
    public HomeController(StudyService studyService, BoardService boardService) {
        this.studyService = studyService;
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Study> studyList = studyService.studyListLimited(3);
        List<Board> boardList = boardService.findForHome(3);
        model.addAttribute("studyList", studyList);
        model.addAttribute("boardList", boardList);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";

    }
}
