package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.dto.Game;
import com.company.RichardFenixU1Capstone.exceptions.GameStoreNotFoundException;
import com.company.RichardFenixU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("game") // http://localhost:8080/game
public class GameWebServiceController {
    private final ServiceLayer serviceLayer;

    //private final GameDao gameDao;

    @Autowired
    public GameWebServiceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGameToDB(@RequestBody @Valid Game game) {
        return serviceLayer.saveGame(game);
    }

    @DeleteMapping(path="/{game_id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void  deleteGameFromDB(@PathVariable int game_id) {
        serviceLayer.removeGame(game_id);
    }

    @GetMapping
    @ResponseStatus(value=HttpStatus.OK)
    public List<Game> getGameListfromDB() {
        return serviceLayer.findAllGames();
    }

    @GetMapping(path="/{game_id}")
    @ResponseStatus(value=HttpStatus.OK)
    public Game getGameFromDB(@PathVariable int game_id) throws Exception {
        Game game = serviceLayer.findGame(game_id);
        if (game == null) {
            throw new GameStoreNotFoundException("Game not found.");
        }
        return game;
    }

    @PutMapping
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateGameInDB(@RequestBody @Valid Game game){
        serviceLayer.updateGame(game);
    }

    @GetMapping(path="title/{title}")
    @ResponseStatus(value=HttpStatus.OK)
    public Game getGamebyTitleFromDB(@PathVariable String title) throws Exception {
        Game game = serviceLayer.findGameByTitle(title);
        if (game == null) {
            throw new GameStoreNotFoundException("Game not found.");
        }
        return game;
    }

    @GetMapping(path="studio/{studio}")
    @ResponseStatus(value=HttpStatus.OK)
    public List<Game> getGamesByStudiofromDB(@PathVariable String studio) throws Exception {
        List<Game> gList = serviceLayer.findGamesByStudio(studio);
        if (gList.size() == 0) {
            throw new GameStoreNotFoundException("No games found.");
        }
        return gList;
    }

    @GetMapping(path="esrb/{esrbRating}")
    @ResponseStatus(value=HttpStatus.OK)
    public List<Game> getGamesByEsrbfromDB(@PathVariable String esrbRating) throws Exception {
        List<Game> gList = serviceLayer.findGamesByEsrbRating(esrbRating);
        if (gList.size() == 0) {
            throw new GameStoreNotFoundException("No games found.");
        }
        return gList;
    }


}
