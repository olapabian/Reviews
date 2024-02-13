package com.example.Reviews.ServicesTests;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import com.example.Reviews.Services.EditReviewService;
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

public class EditReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private MovieRepository movieRepository;
    @Mock
    private PhotoRepository photoRepository;
    @Mock
    private Model model;

    private EditReviewService editReviewService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        editReviewService = new EditReviewService(reviewRepository, movieRepository, photoRepository);
    }

    @Test
    public void testShowEditReviewPage() {
        // Arrange
        Long id = 1L;
        Long reviewId = 1L;
        Movie movie = new Movie();
        movie.setTitle("Test Movie");
        Review review = new Review();
        List<Photo> photoList = new ArrayList<>();
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
        when(reviewRepository.findById(anyLong())).thenReturn(Optional.of(review));

        // Act
        String viewName = editReviewService.showEditReviewPage(id, model);

        // Assert
        assertEquals("/MyReviewPages/editReview", viewName);
        verify(movieRepository, times(1)).findById(id);
        verify(model, times(1)).addAttribute(eq("movie"), any(Movie.class));
    }



    @Test
    public void testEditReview() {
        // Arrange
        Long id = 1L;
        Long reviewId = 1L;
        Long photo1Id = 1L;
        Long photo2Id = 2L;
        Long photo3Id = 3L;
        Movie movie = new Movie();
        Review review = new Review();
        String photos1 = "photo1.jpg";
        String photos2 = "photo2.jpg";
        String photos3 = "photo3.jpg";

        // Mocking behavior for movie and review retrieval
        when(movieRepository.findById(id)).thenReturn(Optional.of(movie));
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));

        // Mocking behavior for photo retrieval
        Photo photo1 = new Photo();
        photo1.setId(photo1Id);
        Photo photo2 = new Photo();
        photo2.setId(photo2Id);
        Photo photo3 = new Photo();
        photo3.setId(photo3Id);
        when(photoRepository.findById(photo1Id)).thenReturn(Optional.of(photo1));
        when(photoRepository.findById(photo2Id)).thenReturn(Optional.of(photo2));
        when(photoRepository.findById(photo3Id)).thenReturn(Optional.of(photo3));

        // Act
        String result = editReviewService.editReview(id, reviewId, photo1Id, photo2Id, photo3Id,
                movie, review, photos1, photos2, photos3);

        // Assert
        assertEquals("redirect:/myReviews", result);
        verify(movieRepository, times(1)).findById(id);
        verify(movieRepository, times(1)).save(movie);
        verify(reviewRepository, times(1)).findById(reviewId);
        verify(reviewRepository, times(1)).save(review);
        verify(photoRepository, times(1)).findById(photo1Id);
        verify(photoRepository, times(1)).findById(photo2Id);
        verify(photoRepository, times(1)).findById(photo3Id);
        verify(photoRepository, times(1)).save(photo1);
        verify(photoRepository, times(1)).save(photo2);
        verify(photoRepository, times(1)).save(photo3);
    }

}
