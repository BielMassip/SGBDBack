package com.example.backsgbdproject.service;

import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.repository.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo;

    public Iterable<Game> getGames(){
        return gameRepo.findAll();
    }

    public Game insertGame(Game game){
        return gameRepo.save(game);
    }

    public Game updateGame(Game game, int id){
        Game game1 = gameRepo.findById(id).get();
        game1.setPrice(game.getPrice());
        return game1;
    }

    public void deleteGame(int id){
        gameRepo.deleteById(id);
    }
}

