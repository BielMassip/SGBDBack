package com.example.backsgbdproject.service;

import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.entity.Review;
import com.example.backsgbdproject.repository.GameRepo;
import com.example.backsgbdproject.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    private ReviewRepo reviewRepo;

    public Iterable<Game> getGames(){
        return gameRepo.findAll();
    }

    public Optional<Game> getGameById(int id){ return gameRepo.findById(id);}

    public List<Game> findByGenre(String genre) {
        return gameRepo.findByGenre(genre);
    }

    public Iterable<Review> getGameReviews(long id){
        return gameRepo.findById((int) id).get().getReviews();
    }
    public Game insertGame(Game game){
        return gameRepo.save(game);
    }

    public Game addReviewToGame(int gameId, Review _review) throws GameNotFoundException {
        Game game1 = gameRepo.findById(gameId).get();

        // Associate the review with the game
        _review.setGameId((long) gameId);
        // Add the review to the game's list of reviews
        game1.getReviews().add(_review);

        // Save the updated game entity
        gameRepo.save(game1);
        return game1;
    }

    public Game updateGame(Game game, int id){
        Game game1 = gameRepo.findById(id).get();
        game1.setName(game.getName());
        game1.setDescription(game.getDescription());
        game1.setGenre(game.getGenre());
        game1.setCompany(game.getCompany());
        game1.setPrice(game.getPrice());
        gameRepo.save(game1);
        return game1;
    }

    public void deleteGame(int id){
        gameRepo.deleteById(id);
    }

}

