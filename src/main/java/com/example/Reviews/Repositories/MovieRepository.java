package com.example.Reviews.Repositories;

import com.example.Reviews.Model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
    Page<Movie> findAllByUserId(Long userId, Pageable pageable);
}
