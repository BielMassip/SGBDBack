package com.example.backsgbdproject.repository;

import com.example.backsgbdproject.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends ElasticsearchRepository<User, Long> {
    List<User> findByUsername(@Param("username") String username);
}
