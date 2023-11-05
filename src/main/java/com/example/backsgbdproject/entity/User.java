package com.example.backsgbdproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NoArgsConstructor
@Data
@Document(indexName = "users")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User {

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    @NotNull
    private Long id;
    @NotNull
    private String username;

    @NotNull
    private String password;
}