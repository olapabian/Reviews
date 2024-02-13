package com.example.Reviews.ServicesTests;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import com.example.Reviews.Services.MyReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class MyReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private MovieRepository movieRepository;
    @Mock
    private PhotoRepository photoRepository;
    @Mock
    private Model model;

    private MyReviewService myReviewService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        myReviewService = new MyReviewService(reviewRepository, movieRepository, photoRepository);
    }

    @Test
    public void testShowMyReviewPage() {
        // Arrange
        Long id = 1L;
        Movie movie = new Movie();
        movie.setTitle("Test Movie");
        Review review = new Review();
        List<Photo> photoList = new ArrayList<>();
        movie.setReview(review); // Ustawienie recenzji w filmie
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
        when(model.addAttribute(anyString(), any())).thenReturn(model);

        // Act
        String viewName = myReviewService.showMyReviewPage(id, model);

        // Assert
        assertEquals("/MyReviewPages/myReviewPage", viewName);
        verify(movieRepository, times(1)).findById(id);
        verify(model, times(1)).addAttribute("movie", movie);
    }


    @Test
    public void testDeleteReview() {
        // Arrange
        Long id = 1L;
        Movie movie = new Movie();
        Review review = new Review();
        List<Photo> photoList = new ArrayList<>();
        Photo photo = new Photo();
        photoList.add(photo);
        movie.setPhotos(photoList);
        movie.setReview(review);
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        // Act
        myReviewService.deleteReview(id);

        // Assert
        verify(movieRepository, times(1)).findById(id);
        verify(photoRepository, times(1)).delete(photo);
        verify(reviewRepository, times(1)).delete(review);
        verify(movieRepository, times(1)).delete(movie);
    }
}
