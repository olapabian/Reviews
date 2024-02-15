// MyReviewsService.java

package com.example.Reviews.Services;

import com.example.Reviews.Model.Movie;
import com.example.Reviews.Model.MyUser;
import com.example.Reviews.Repositories.MovieRepository;
import com.example.Reviews.Repositories.MyUserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

// Import sesji HTTP

@AllArgsConstructor
@Service
public class MyReviewsService {
    private final MovieRepository movieRepository;
    private final MyUserRepository myUserRepository;

    // Przekazanie sesji HTTP jako argument metody
    public String showMyReviewsPage(Model model, HttpSession session, int page, int size, String sort) {
        // Sprawdzenie, czy sesja zawiera wartości stronnicowania
        if(session.getAttribute("page") != null)
            page = (int) session.getAttribute("page");
        if(session.getAttribute("size") != null)
            size = (int) session.getAttribute("size");
        if(session.getAttribute("sort") != null)
            sort = (String) session.getAttribute("sort");

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sort.substring(sort.lastIndexOf("_") + 1)), sort.substring(0, sort.lastIndexOf("_"))));

        //Pobranie username
        String username = (String) session.getAttribute("username");
        Optional<MyUser> myUserOptional = myUserRepository.findByUsername(username);
        if(myUserOptional.isPresent()){
            MyUser myUser = myUserOptional.get();
            Page<Movie> moviePage = movieRepository.findAllByUserId(myUser.getId(),pageable);
            model.addAttribute("movieList", moviePage);
        }

        return "/MyReviewPages/myReviewsPage";
    }
}
