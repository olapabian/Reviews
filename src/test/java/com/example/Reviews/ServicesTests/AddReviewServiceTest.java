package com.example.Reviews.ServicesTests;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.MyUser;
import com.example.Reviews.Model.Photo;
import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.MyUserRepository;
import com.example.Reviews.Repositories.PhotoRepository;
import com.example.Reviews.Repositories.ReviewRepository;
import com.example.Reviews.Services.AddReviewService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AddReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private MovieRepository movieRepository;
    @Mock
    private PhotoRepository photoRepository;
    @Mock
    private MyUserRepository myUserRepository;
    @Mock
    private HttpSession session;

    private AddReviewService addReviewService;

    @BeforeEach //przed testem sie zadzieje
    public void setUp() {
        MockitoAnnotations.initMocks(this);//inicjowanie mocków czyli tych u gory
        addReviewService = new AddReviewService(reviewRepository, movieRepository, photoRepository, myUserRepository, session);
    }

    @Test
    public void testAddReview() {
        // Arrange
        Movie movie = new Movie();
        Review review = new Review();
        String photos1 = "photo1.jpg";
        String photos2 = "photo2.jpg";
        String photos3 = "photo3.jpg";



        String username = "testuser";
        MyUser myUser = new MyUser();
        myUser.setUsername(username);
        //symulacja sesji httpd zwracajaca username w momencie wywolanie metoody getatribute
        when(session.getAttribute("username")).thenReturn(username);
        //symulacja zachowania repozytorium usera aby zwracalo obiekt optional uzytkowanika na podstawie nazwy uzytkownika
        when(myUserRepository.findByUsername(username)).thenReturn(Optional.of(myUser));

        // Act
        addReviewService.addReview(movie, review, photos1, photos2, photos3);
        // Assert
        //sprawdza czy metoda find by username zostala wywolana raz z oczekiwana nazwa uzytkownika
        verify(myUserRepository, times(1)).findByUsername(username);
        verify(reviewRepository, times(1)).save(review);
        verify(movieRepository, times(2)).save(movie);
    }

}
