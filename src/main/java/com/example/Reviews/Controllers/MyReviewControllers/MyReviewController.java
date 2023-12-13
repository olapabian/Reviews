package com.example.Reviews.Controllers.MyReviewControllers;

import com.example.Reviews.Model.Review;
import com.example.Reviews.Repositories.ReviewRepository;
import jakarta.servlet.http.HttpSession;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/myReview")
public class MyReviewController {
    @GetMapping
    public String MyReviewPage() {
        return "/MyReviewPages/myReviewPage";
    }
}