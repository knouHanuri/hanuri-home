package hanuri.website.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest httpServletRequest, Model model) {
        HttpSession session = httpServletRequest.getSession(true);
        model.addAttribute("member", session.getAttribute("member"));
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";

    }
}
