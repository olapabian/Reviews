// MyReviewService.java

package com.example.Reviews.Services;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class MyReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final PhotoRepository photoRepository;

    public MyReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository,
                           PhotoRepository photoRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
        this.photoRepository = photoRepository;
    }

    @Transactional
    public String showMyReviewPage(Long id, Model model) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            model.addAttribute("movie", movie);
            Review review = movie.getReview();
            model.addAttribute("review", review);
            List<Photo> photoList = movie.getPhotos();
            model.addAttribute("photos", photoList);
            return "/MyReviewPages/myReviewPage";
        } else {
            return "redirect:/myReviews"; // Or handle this case differently
        }
    }

    @Transactional
    public void deleteReview(Long id) {
        if (id != null) {
            Optional<Movie> movieOptional = movieRepository.findById(id);
            if (movieOptional.isPresent()) {
                Movie movie = movieOptional.get();
                Review review = movie.getReview();
                List<Photo> photoList = movie.getPhotos();
                for (Photo photo : photoList) {
                    photoRepository.delete(photo);
                }
                movieRepository.delete(movie);
                reviewRepository.delete(review);
            }
        }
    }
}
