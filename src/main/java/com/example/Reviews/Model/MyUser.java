package com.example.Reviews.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "my_user")
public class MyUser {
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

//    @Column(name = "reviews")
//    private List<Review> reviews;

//    @Column(name = "confirm_password", nullable = false)
//    private String confirmPassword;

    @NotNull
    @Column
    private List<String> roles;
}

