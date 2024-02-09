// AddReviewService.java

package com.example.Reviews.Services;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final PhotoRepository photoRepository;

    public AddReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository,
                            PhotoRepository photoRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
        this.photoRepository = photoRepository;
    }

    @Transactional
    public boolean addReview(Movie movie, Review review, String photos1, String photos2, String photos3) {
        try {
            reviewRepository.save(review);
            movie.setReview(review);

            List<Photo> photoList = new ArrayList<>();
            movieRepository.save(movie);
            Optional<Movie> movieOptional = movieRepository.findByTitle(movie.getTitle()).stream().findFirst();
            if (movieOptional.isPresent()) {
                Movie savedMovie = movieOptional.get();

                savePhoto(photos1, savedMovie, photoList);
                savePhoto(photos2, savedMovie, photoList);
                savePhoto(photos3, savedMovie, photoList);
            }

            movie.setPhotos(photoList);
            movieRepository.save(movie);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void savePhoto(String photoUrl, Movie movie, List<Photo> photoList) {
        Photo photo = new Photo();
        photo.setUrl(photoUrl);
        photo.setMovie_id(movie.getId());
        photoRepository.save(photo);
        photoList.add(photo);
    }
}
