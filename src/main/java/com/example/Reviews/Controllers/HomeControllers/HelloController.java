package com.example.Reviews.Controllers.HomeControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloController {
    @GetMapping("/helloPage")
    public String HelloPage() {
        return "/HomePages/helloPage";
    }

    @PostMapping("/login")
    public String submit( ) {
            return "redirect:/login";
    }

//    @PostMapping("/register")
//    public String submit2( ) {
//        return "redirect:/register";
//    }
}
