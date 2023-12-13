package com.example.Reviews.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Review {
    @GeneratedValue
    @Id
    private Long id;
    private String title;
    private String rezyser;
    private String gatunek;
    private String plakat;
    private String review;
    private int stars; //1-10
}
