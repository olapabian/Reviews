package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/addReview")
public class AddReviewController {
        private final ReviewRepository reviewRepository;
        private final MovieRepository movieRepository;
        private final PhotoRepository photoRepository;
        @GetMapping
        public String AddReviewPage() {
        return "/MyReviewPages/addReviewPage";
        }
        @PostMapping("/add")
        public String addForm(Movie movie, Review review, @RequestParam("Photos1") String photos1,@RequestParam("Photos2")  String photos2,@RequestParam("Photos3")  String photos3) {
                reviewRepository.save(review);
                movie.setReview(review);

                // Creating a list to store photos
                List<Photo> photoList = new ArrayList<>();
                movieRepository.save(movie);
                Optional<Movie> movieOptional = Optional.ofNullable(movieRepository.findByTitle(movie.getTitle()).get(0));
                if(movieOptional.isPresent()){
                        Movie movie1 = movieOptional.get();

                        // Creating and saving the first photo
                        Photo photo1 = new Photo();
                        photo1.setUrl(photos1);
                        photo1.setMovie_id(movie1.getId());
                        photoRepository.save(photo1);
                        photoList.add(photo1);

                        // Creating and saving the second photo
                        Photo photo2 = new Photo();
                        photo2.setUrl(photos2);
                        photo2.setMovie_id(movie1.getId());
                        photoRepository.save(photo2);
                        photoList.add(photo2);

                        // Creating and saving the third photo
                        Photo photo3 = new Photo();
                        photo3.setUrl(photos3);
                        photo3.setMovie_id(movie1.getId());
                        photoRepository.save(photo3);
                        photoList.add(photo3);
                }


                // Setting the list of photos to the movie
                movie.setPhotos(photoList);

                // Saving the movie
                movieRepository.save(movie);

                return "redirect:/myReviews";
        }


}

