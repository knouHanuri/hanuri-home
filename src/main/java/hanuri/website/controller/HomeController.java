package hanuri.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/layout/header")
    public String header(){
        return "layout/header";
    }

    @GetMapping("/layout/footer")
    public String footer(){
        return "layout/footer";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
