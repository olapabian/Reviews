// MyReviewsService.java

package com.example.Reviews.Services;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@AllArgsConstructor
@Service
public class MyReviewsService {
    private final MovieRepository movieRepository;

    public String showMyReviewsPage(Model model, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sort.substring(sort.lastIndexOf("_") + 1)), sort.substring(0, sort.lastIndexOf("_"))));
        Page<Movie> moviePage = movieRepository.findAll(pageable);
        model.addAttribute("movieList", moviePage);
        return "/MyReviewPages/myReviewsPage";
    }
}
