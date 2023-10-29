package com.example.backsgbdproject.controller;

import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/apis/game")
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/findAll")
    Iterable<Game> findAll(){
        return gameService.getGames();
    }

    @GetMapping("/findById/{id}")
    Optional<Game> findById(@PathVariable int id) {  return gameService.getGameById(id); }

    @PostMapping("/insert")
    Game insertGame(@RequestBody Game game){
        return gameService.insertGame(game);
    }

    @PutMapping("/update")
    Game updateGame(@RequestBody Game game){
        return gameService.updateGame(game, game.getId());
    }
    @DeleteMapping("/delete/{id}")
    void deleteGame(@PathVariable int id){
        gameService.deleteGame(id);
    }
}