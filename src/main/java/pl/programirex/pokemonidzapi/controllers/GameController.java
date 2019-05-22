package pl.programirex.pokemonidzapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.repository.UserRepository;
//import pl.programirex.pokemonidzapi.service.IUserService;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/game")
public class GameController {
//    @Autowired
//    IUserService usersService;

    @Autowired
    UserRepository usersRepository;

    ArrayList<User> usersList = new ArrayList<User>();

    GameController()
    {
        usersList.add(new User("TestUser1", "test", "test@test.pl", "Jan", "Kowalski", 19, 7, (long) 2));
        usersList.add(new User("TestUser2", "haslohaslo", "email@email.email", "Anna", "Nowak", 3, 15, (long) 1));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserById")
    @ResponseBody
    public User getUserById(@RequestParam Long id) {
        return usersList.stream()
                .filter(user -> id.equals(user.getId()))
                .findAny()
                .orElse(null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserByEmail")
    @ResponseBody
    public User getUserByEmail(@RequestParam String email) {
                return usersList.stream()
                .filter(user -> email.equals(user.getEmail()))
                .findAny()
                .orElse(null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public ArrayList<User> getAllUsers() {
        return usersList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    @ResponseBody
    public ResponseEntity<User> register(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password, @RequestParam(name = "email") String email) {
        User addedUser = new User(login, password, email);
        usersList.add(addedUser);

        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    @ResponseBody
    public ResponseEntity<User> login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
//        public ResponseEntity<User> login(@RequestBody LoginDto loginDto) {
        User userLogged = usersList.stream()
                .filter(user -> email.equals(user.getEmail()) && password.equals(user.getPassword()))
                .findAny()
                .orElse(null);

        if(userLogged == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userLogged, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllUserPokemons")
    @ResponseBody
    public ArrayList<String> getEm(@RequestParam Long id) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Bulbasaur");
        list.add("Greninja");
        list.add("Incineroar");
        return list;
    }

}

