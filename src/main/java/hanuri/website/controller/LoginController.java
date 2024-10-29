package hanuri.website.controller;

import hanuri.website.domain.dto.Login.LoginRequest;
import hanuri.website.domain.dto.Member;
import hanuri.website.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("loginRequest", loginRequest);
        return "login";
    }

    @PostMapping("/login")
    public String login(LoginRequest loginRequest, HttpServletRequest httpServletRequest, Model model) {
        Member member = loginService.login(loginRequest);
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("member", member);
        session.setMaxInactiveInterval(1800);   //30분동안 유지
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest, Model model) {
        HttpSession session = httpServletRequest.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

}
