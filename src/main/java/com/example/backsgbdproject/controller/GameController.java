package com.example.backsgbdproject.controller;

import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/findAll")
    Iterable<Game> findAll(){
        return gameService.getGames();
    }

    @PostMapping("/insert")
    Game insertGame(@RequestBody Game game){
        return gameService.insertGame(game);
    }
}