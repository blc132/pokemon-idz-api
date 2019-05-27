package pl.programirex.pokemonidzapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.programirex.pokemonidzapi.dto.RegisterDto;
import pl.programirex.pokemonidzapi.dto.SavePokemonDto;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.entity.UserPokemon;
import pl.programirex.pokemonidzapi.repository.UserPokemonRepository;
import pl.programirex.pokemonidzapi.repository.UserRepository;
import pl.programirex.pokemonidzapi.service.GameService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private GameService gameService;

    public User findUserByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    static Long getRandomPokemonId() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 50 + 1;
        Long randomLong = (long) randomDouble;
        return randomLong;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getmon/{id:[\\d]+}/{login}")
    @ResponseBody
    public ResponseEntity getPokemon(@PathVariable("id") Long pokemonId, @PathVariable("login") String login) {
        if (findUserByLogin(login) != null) {
            UserPokemon userPokemon = new UserPokemon(pokemonId, findUserByLogin(login));
            return new ResponseEntity<>("Dodano pokemona", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wystąpił błąd podczas dodawania pokemona", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/savePokemon")
    @ResponseBody
    public ResponseEntity savePokemon(@Valid @RequestBody SavePokemonDto savePokemonDto, BindingResult result) {
        UserPokemon userPokemon = new UserPokemon();
        if (!result.hasErrors()) {
            userPokemon = gameService.savePokemon(savePokemonDto);
        }
        if (userPokemon == null || userPokemon.getId() == null) {
            return new ResponseEntity<>("Wystąpił błąd podczas zapisywania pokemona", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userPokemon, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fight")
    @ResponseBody
    public String calculateFight(){
        return "todo";
    }

}

