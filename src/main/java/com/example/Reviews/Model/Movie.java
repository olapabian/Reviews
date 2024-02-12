package com.example.Reviews.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "movie_id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "title",nullable = false)
    private String title;

    @NotNull
    @Column(name = "director")
    private String director;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "genre")
    private String genre;

    @NotNull
    @Column(name = "release_year")
    private String releaseYear;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @NotNull
    @Column(name = "poster_img")
    private String posterImg;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private List<Photo> photos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_movies",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<MyUser> users;


}
