package com.example.Reviews.Repositories;


import com.example.Reviews.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String login);
}