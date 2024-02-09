// MyReviewsControllers.java

package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import com.example.Reviews.Services.MyReviewsService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
@RequestMapping("/myReviews")
public class MyReviewsControllers {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final MyReviewsService myReviewsService;

    @GetMapping
    public String MyReviewsPage(Model model, HttpSession httpSession,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "3") int size,
                                @RequestParam(defaultValue = "title_ASC") String sort) {
        return myReviewsService.showMyReviewsPage(model, page, size, sort);
    }
}
