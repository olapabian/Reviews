// AddReviewController.java

package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Services.AddReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/addReview")
public class AddReviewController {

    private final AddReviewService addReviewService;

    public AddReviewController(AddReviewService addReviewService) {
        this.addReviewService = addReviewService;
    }

    @GetMapping
    public String AddReviewPage() {
        return "/MyReviewPages/addReviewPage";
    }

    @PostMapping("/add")
    public String addForm(Movie movie, Review review, @RequestParam("Photos1") String photos1,
                          @RequestParam("Photos2") String photos2, @RequestParam("Photos3") String photos3,
                          RedirectAttributes redirectAttributes) {
        addReviewService.addReview(movie, review, photos1, photos2, photos3);

        return "redirect:/myReviews";
    }
}
