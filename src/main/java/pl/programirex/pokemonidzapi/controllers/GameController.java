package pl.programirex.pokemonidzapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.entity.UserPokemon;
import pl.programirex.pokemonidzapi.repository.UserPokemonRepository;
import pl.programirex.pokemonidzapi.repository.UserRepository;

@Controller
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private UserPokemonRepository pokemonRepository;

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

    @RequestMapping(method = RequestMethod.POST, value = "/getrand/{login}")
    @ResponseBody
    public ResponseEntity getRandomPokemon(@PathVariable("login") String login) {
        if (findUserByLogin(login) != null) {
            UserPokemon userPokemon = new UserPokemon(getRandomPokemonId(), findUserByLogin(login));
            return new ResponseEntity<>("Dodano losowego pokemona", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wystąpił błąd podczas dodawania losowego pokemona", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fight")
    @ResponseBody
    public String calculateFight(){
        return "todo";
    }

}

