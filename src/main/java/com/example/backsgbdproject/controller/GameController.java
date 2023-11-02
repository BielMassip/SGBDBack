package com.example.backsgbdproject.controller;

import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.entity.Review;
import com.example.backsgbdproject.service.GameNotFoundException;
import com.example.backsgbdproject.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/findAllReviewsByGameId/{game_id}")
    Iterable<Review> findAllReviewsByGameId(@PathVariable long game_id){
        return gameService.getGameReviews(game_id);
    }

    @PostMapping("/addGameReview/{game_id}")
    ResponseEntity<String> addGameReview(@RequestBody Review review,@PathVariable int game_id) throws GameNotFoundException {
        try {
            gameService.addReviewToGame(game_id, review);
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        } catch (GameNotFoundException e) {
            return new ResponseEntity<>("Game not found with ID: " + game_id, HttpStatus.NOT_FOUND);
        }
    }

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

    @GetMapping("/findByGenre/{genre}")
    public List<Game> findByGenre(@PathVariable String genre) {
        return gameService.findByGenre(genre);
    }
}