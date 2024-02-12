package com.example.Reviews.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id", nullable = false)
    private Long id;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movie_id;

    @Column(name = "photo_url")
    private String url;

    public Photo(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", url='" + url + '\'' +
                '}';
    }
}
