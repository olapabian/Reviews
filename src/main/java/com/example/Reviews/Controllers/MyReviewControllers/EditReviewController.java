package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
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
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final PhotoRepository photoRepository;

    @GetMapping("/editReviewPage")
    public String showPage(@RequestParam("id") Long id, Model model) {

        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            model.addAttribute("movie", movie);
            Review review = movie.getReview();
            model.addAttribute("review", review);
            List<Photo> photoList = movie.getPhotos();
            model.addAttribute("photos", photoList);

        }
        return "/MyReviewPages/editReview";
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

        Optional<Movie> movieOptional = movieRepository.findById(id);
        Movie m1 = null;
        if (movieOptional.isPresent()) {
            m1 = movieOptional.get();
            m1.setTitle(movie.getTitle());
            m1.setDescription(movie.getDescription());
            m1.setDirector(movie.getDirector());
            m1.setGenre(movie.getGenre());
            m1.setPosterImg(movie.getPosterImg());
            m1.setReleaseYear(movie.getReleaseYear());
            movieRepository.save(m1);
        }


        Optional<Review> reviewOptional = reviewRepository.findById(review_id);
        Review r1 = null;
        if (reviewOptional.isPresent()) {
            r1 = reviewOptional.get();
            r1.setText(review.getText());
            r1.setRate(review.getRate());
            r1.setId(review_id);
            reviewRepository.save(r1);
        }
//
        Optional<Photo> photoOptional1 = photoRepository.findById(photo1_id);
        Photo p1 = null;
        if (photoOptional1.isPresent()) {
            p1 = photoOptional1.get();
            p1.setUrl(photos1);
            p1.setMovie_id(id);
            p1.setId(photo1_id);
            System.out.println(p1.getId());
            photoRepository.save(p1);
        }
//
        Optional<Photo> photoOptional2 = photoRepository.findById(photo2_id);
        Photo p2 = null;
        if (photoOptional2.isPresent()) {
            p2 = photoOptional2.get();
            p2.setUrl(photos2);
            p2.setMovie_id(id);
            p2.setId(photo2_id);
            System.out.println(p2.getId());
            photoRepository.save(p2);
        }

        Optional<Photo> photoOptional3 = photoRepository.findById(photo3_id);
        Photo p3 = null;
        if (photoOptional3.isPresent()) {
            p3 = photoOptional3.get();
            p3.setUrl(photos3);
            p3.setMovie_id(id);
            p3.setId(photo3_id);
            System.out.println(p3.getId());
            photoRepository.save(p3);
        }
        return "redirect:/myReviews";
    }
}
