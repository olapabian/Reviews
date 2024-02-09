// EditReviewService.java

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
public class EditReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final PhotoRepository photoRepository;

    public EditReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository,
                             PhotoRepository photoRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
        this.photoRepository = photoRepository;
    }

    @Transactional
    public String showEditReviewPage(Long id, Model model) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            model.addAttribute("movie", movie);
            Review review = movie.getReview();
            model.addAttribute("review", review);
            List<Photo> photoList = movie.getPhotos();
            model.addAttribute("photos", photoList);
            return "/MyReviewPages/editReview";
        } else {
            return "redirect:/myReviews"; // Or handle this case differently
        }
    }

    @Transactional
    public String editReview(Long id, Long review_id, Long photo1_id, Long photo2_id, Long photo3_id,
                             Movie movie, Review review, String photos1, String photos2, String photos3) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie m1 = movieOptional.get();
            m1.setTitle(movie.getTitle());
            m1.setDescription(movie.getDescription());
            m1.setDirector(movie.getDirector());
            m1.setGenre(movie.getGenre());
            m1.setPosterImg(movie.getPosterImg());
            m1.setReleaseYear(movie.getReleaseYear());
            movieRepository.save(m1);
        }

        Optional<Review> reviewOptional = reviewRepository.findById(review_id);
        if (reviewOptional.isPresent()) {
            Review r1 = reviewOptional.get();
            r1.setText(review.getText());
            r1.setRate(review.getRate());
            r1.setId(review_id);
            reviewRepository.save(r1);
        }

        savePhoto(photo1_id, id, photos1);
        savePhoto(photo2_id, id, photos2);
        savePhoto(photo3_id, id, photos3);

        return "redirect:/myReviews";
    }

    private void savePhoto(Long photoId, Long movieId, String photoUrl) {
        Optional<Photo> photoOptional = photoRepository.findById(photoId);
        if (photoOptional.isPresent()) {
            Photo photo = photoOptional.get();
            photo.setUrl(photoUrl);
            photo.setMovie_id(movieId);
            photo.setId(photoId);
            photoRepository.save(photo);
        }
    }
}
