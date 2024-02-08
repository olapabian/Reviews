package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final MovieRepository movieRepository;
//    @GetMapping
//    public String MyReviewsPage(Model model, HttpSession httpSession, Review review) {
//        List<Movie> movieList = movieRepository.findAll();
//        model.addAttribute("movieList",movieList);
//        return "/MyReviewPages/myReviewsPage";
//    }
    @GetMapping
    public String MyReviewsPage(Model model, HttpSession httpSession,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "3") int size) {

        // Tworzymy obiekt Pageable, który określa numer strony oraz ilość elementów na stronie
        Pageable pageable = PageRequest.of(page, size);

        // Pobieramy stronę recenzji z repozytorium
        Page<Movie> moviePage = movieRepository.findAll(pageable);

        // Dodajemy stronę recenzji do modelu
        model.addAttribute("movieList", moviePage);

        return "/MyReviewPages/myReviewsPage";
    }
}
