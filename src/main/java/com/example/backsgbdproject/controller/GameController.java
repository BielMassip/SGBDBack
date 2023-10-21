package com.example.backsgbdproject.controller;

import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/findAll")
    Iterable<Game> findAll(){
        return gameService.getGames();
    }
}