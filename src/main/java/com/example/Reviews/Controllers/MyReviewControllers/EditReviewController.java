package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class EditReviewController {
    private final ReviewRepository reviewRepository;
    @GetMapping("/editReview")
    public String editReview(@RequestParam("id") Long id, Model model) {
        if (id != null){
            Optional<Review> reviewOptional = reviewRepository.findById(id);
            if(reviewOptional.isPresent()){
                Review review = reviewOptional.get();
                reviewRepository.delete(review);
            }
        }

        return "redirect:/myReviews";
    }
}
