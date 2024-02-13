package com.example.Reviews.Controllers.HomeControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String login() {
        return "/HomePages/login";
    }

    @PostMapping
    public String HomePage(@RequestParam("username") String username) {
        return "redirect:/home";
    }

}
