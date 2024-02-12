// MyReviewService.java

package com.example.Reviews.Services;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.MyUser;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.MyUserRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor

@Service
public class MyReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final PhotoRepository photoRepository;

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
        System.out.println("kkkkkkkkkkkkkkkkkkkkdsaiocjushbfniuerfgbhireee5rtgddddddddddddddddddddddddddddddddddddddddd");
        System.out.println(id);
        if (id != null) {
            Optional<Movie> movieOptional = movieRepository.findById(id);
            if (movieOptional.isPresent()) {
                Movie movie = movieOptional.get();
                List<Photo> photoList = movie.getPhotos();
                for (Photo photo : photoList) {
                    System.out.println(photo.getId());
                    System.out.println(photo.getUrl());
                    System.out.println(photo.getMovie_id());
                    photoRepository.delete(photo);
                }
                Review review = movie.getReview();
                movieRepository.delete(movie);
                if (review != null) {
                    reviewRepository.delete(review);
                }
            }
        }
    }

}
