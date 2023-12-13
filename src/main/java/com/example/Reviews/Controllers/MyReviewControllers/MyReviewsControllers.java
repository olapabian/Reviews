package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.ReviewRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/myReviews")
public class MyReviewsControllers {
    private final ReviewRepository reviewRepository;
    @GetMapping
    public String MyReviewsPage(Model model, HttpSession httpSession, Review review) {
        List<Review> reviewList = reviewRepository.findAll();
        model.addAttribute("reviewList", reviewList);
        return "/MyReviewPages/myReviewsPage";
    }
    @GetMapping("/myReview")
    public String OneReviewPage(@RequestParam("id") Long id, Model model) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            Review review = reviewOptional.get();
            model.addAttribute("review",review);
        }
        return "/myReview";
    }

}
