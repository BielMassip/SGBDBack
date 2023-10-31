package com.example.backsgbdproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String company;

    private String genre;

    private String subgenre;

    private String description;

    private int rating;

    private String img;

    private double price;

    @OneToMany(mappedBy = "game")
    private List<Review> reviews = new ArrayList<>();;

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", subgenre='" + subgenre + '\'' +
                ", company='" + company + '\'' +
                ", rating=" + rating +
                ", img='" + img + '\'' +
                ", price=" + price +
                // Omitting reviews here to avoid circular reference
                '}';
    }
}