package com.example.Reviews.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
=======
import org.antlr.v4.runtime.misc.NotNull;
>>>>>>> 32c33eb846bc164d97b48cece151813d0a2be2ec

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "my_user")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
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

<<<<<<< HEAD
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )


    //WYBACZ NIE UMIEM W TO :(((

    @Column(name = "roles", nullable = false)
    private String roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_movies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;

=======
    @NotNull
    @Column
    private List<String> roles;
>>>>>>> 32c33eb846bc164d97b48cece151813d0a2be2ec
}

