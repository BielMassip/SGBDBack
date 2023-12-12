package com.example.backsgbdproject.controller;

import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.entity.Review;
import com.example.backsgbdproject.service.GameNotFoundException;
import com.example.backsgbdproject.service.GameService;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.Response;
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
    Iterable<Game> findAll(){ return gameService.getGames(); }

    @GetMapping("/findById/{id}")
    Optional<Game> findById(@PathVariable String id) {  return gameService.getGameById(id); }

    @GetMapping("/findAllReviewsByGameId/{game_id}")
    Iterable<Review> findAllReviewsByGameId(@PathVariable String game_id){
        return gameService.getGameReviews(game_id);
    }
    @PutMapping("/setGameRating/{game_id}")
    ResponseEntity<String> setGameRating(@RequestParam int rating, @PathVariable String game_id){
        gameService.setGameRating(game_id, rating);
        return new ResponseEntity<>("Rating set successfully", HttpStatus.CREATED);
    }
    @PostMapping("/addGameReview/{game_id}")
    ResponseEntity<String> addGameReview(@RequestBody Review review,@PathVariable String game_id) throws GameNotFoundException {
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
    void deleteGame(@PathVariable String id){
        gameService.deleteGame(id);
    }

    @GetMapping("/findByGenre/{genre}")
    public List<Game> findByGenre(@PathVariable String genre) {
        return gameService.findByGenre(genre);
    }

    @GetMapping("/search")
    public List<Game> searchGames(@RequestParam String field, @RequestParam String value) {
        return gameService.searchGames(field, value);
    }

    @GetMapping(path="/carregarBD")
    public String register() {
        gameService.carregarBD();
        return BaseController.OK_MESSAGE;
    }
}