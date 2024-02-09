// MyReviewController.java

package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import com.example.Reviews.Services.MyReviewService;
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
@RequestMapping("/myReview")
public class MyReviewController {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final PhotoRepository photoRepository;
    private final MyReviewService myReviewService;
    @GetMapping
    public String MyReviewPage(@RequestParam("id") Long id, Model model) {
        return myReviewService.showMyReviewPage(id, model);
    }

    @PostMapping("/deleteReview")
    public String deleteReview(@RequestParam("id") Long id, Model model) {
        myReviewService.deleteReview(id);
        return "redirect:/myReviews";
    }
}
