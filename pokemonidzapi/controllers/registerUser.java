package pl.programirex.pokemonidzapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.programirex.pokemonidzapi.entity.*;

@Controller
public class registerUser {

    @GetMapping("/register")
    @ResponseBody
    public User registerUser(@RequestParam(name = "login") String login) {
        return new User(login);
    }
}