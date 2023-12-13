package com.example.Reviews.Controllers.HomeControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String HomePage() {
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