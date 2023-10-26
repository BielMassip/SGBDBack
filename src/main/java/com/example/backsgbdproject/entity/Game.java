package com.example.backsgbdproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "games")
public class Game {

    private int id;

    private String name;

    private String description;

    private String genre;

    private String subgenre;

    private String company;

    private double price;
}