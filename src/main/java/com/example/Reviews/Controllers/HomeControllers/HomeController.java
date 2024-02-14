package com.example.Reviews.Controllers.HomeControllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {



    @PostMapping
    public String HomePage() {
        return "redirect:/home";
    }
    @GetMapping
    public String Home(){
        return "/HomePages/homePage";
    }
    @PostMapping("/addReviewForm")
    public String addReviewForm( ) {
        return "redirect:/addReview";
    }
    @PostMapping("/myReviewsForm")
    public String myReviewsForm( ) {
        return "redirect:/myReviews";
    }
}