// EditReviewController.java

package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import com.example.Reviews.Services.EditReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class EditReviewController {

    private final EditReviewService editReviewService;

    @GetMapping("/editReviewPage")
    public String showPage(@RequestParam("id") Long id, Model model) {
        return editReviewService.showEditReviewPage(id, model);
    }

    @PostMapping("/editReview")
    public String editReview(@RequestParam("id") Long id, @RequestParam("review_id") Long review_id,
                             @RequestParam("photo1_id") Long photo1_id,
                             @RequestParam("photo2_id") Long photo2_id,
                             @RequestParam("photo3_id") Long photo3_id,
                             Movie movie, Review review,
                             @RequestParam("Photos1") String photos1,
                             @RequestParam("Photos2") String photos2,
                             @RequestParam("Photos3") String photos3) {
        return editReviewService.editReview(id, review_id, photo1_id, photo2_id, photo3_id, movie, review, photos1, photos2, photos3);
    }
}
