package hanuri.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/contact")
    public String contact(){
        return "/about/contact";
    }

    @GetMapping("/activities")
    public String activities(){
        return "/about/activities";
    }

    @GetMapping("/findus")
    public String findus(){
        return "/about/findus";
    }

    @GetMapping("/maptest")
    public String maptest(){
        return "/about/maptest";
    }
}
