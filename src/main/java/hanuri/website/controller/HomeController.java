package hanuri.website.controller;


import hanuri.website.dto.Study;
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

    @Autowired
    private StudyService studyService;

    @GetMapping("/")
    public String home(Model model) {
        List<Study> studyList = studyService.studyListLimited(3);
        model.addAttribute("studyList", studyList);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";

    }
}