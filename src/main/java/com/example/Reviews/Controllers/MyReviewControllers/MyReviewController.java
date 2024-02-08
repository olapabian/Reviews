package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import jakarta.servlet.http.HttpSession;
import jdk.dynalink.linker.LinkerServices;
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
    ReviewRepository reviewRepository;
    MovieRepository movieRepository;
    PhotoRepository photoRepository;
    @GetMapping
    public String MyReviewPage(@RequestParam("id") Long id, Model model) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if(movieOptional.isPresent()){
            Movie movie = movieOptional.get();
            model.addAttribute("movie",movie);
            Review review=movie.getReview();
            model.addAttribute("review",review);
            List<Photo> photoList = movie.getPhotos();
            model.addAttribute("phothos",photoList);
        }

        return "/MyReviewPages/myReviewPage";
    }
    @PostMapping("/deleteReview")
    public String deleteReview(@RequestParam("id") Long id, Model model) {
        if (id != null){
            Optional<Movie> movieOptional = movieRepository.findById(id);
            if(movieOptional.isPresent()){
                Movie movie = movieOptional.get();

                Review review = movie.getReview();

                List<Photo> photoList = movie.getPhotos();
                for (int i = 0; i < photoList.size(); i++) {
                    photoRepository.delete(photoList.get(i));
                }
                movieRepository.delete(movie);
                reviewRepository.delete(review);
            }
        }

        return "redirect:/myReviews";
    }
}