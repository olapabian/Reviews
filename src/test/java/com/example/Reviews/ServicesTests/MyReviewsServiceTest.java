package com.example.Reviews.ServicesTests;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.MyUser;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.MyUserRepository;
import com.example.Reviews.Services.MyReviewsService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyReviewsServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private MyUserRepository myUserRepository;

    @Mock
    private Model model;

    @Mock
    private Page<Movie> moviePage;
    @Mock
    private HttpSession session;
    @InjectMocks
    private MyReviewsService myReviewsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowMyReviewsPage() {
        // Mock data
        String username = "testUser";
        MyUser myUser = new MyUser();
        myUser.setId(1L);
        myUser.setUsername(username);
        when(myUserRepository.findByUsername(username)).thenReturn(Optional.of(myUser));

        int page = 0;
        int size = 10;
        String sort = "field_asc"; // Poprawiony format łańcucha sortowania

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sort.substring(sort.lastIndexOf("_") + 1)), sort.substring(0, sort.lastIndexOf("_"))));
        when(movieRepository.findAllByUserId(myUser.getId(), pageable)).thenReturn(moviePage);

        // Call the method
        String result = myReviewsService.showMyReviewsPage(model, page, size, sort);

        // Verify interactions
        verify(session, times(1)).getAttribute("username");

        // Assertions
        assertEquals("/MyReviewPages/myReviewsPage", result);
    }

}
