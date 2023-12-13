package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@AllArgsConstructor
@Controller
@RequestMapping("/addReview")
public class AddReviewController {
        private final ReviewRepository reviewRepository;
        @GetMapping
        public String AddReviewPage() {
        return "/MyReviewPages/addReviewPage";
        }
        @PostMapping("/add")
        public String addForm(Review review) {

                reviewRepository.save(review);
                return "redirect:/myReviews";
        }
}

