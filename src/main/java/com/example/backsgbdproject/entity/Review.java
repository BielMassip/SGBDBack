package com.example.backsgbdproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "reviews")
public class Review {

    private int id;

    private String author;

    @ManyToOne // Many reviews can be written for one game
    @JoinColumn(name = "id") // This is the foreign key column in the "Book" table
    private Game game;

    private String comment;

    private int like;

    private int rating;

}