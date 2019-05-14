package pl.programirex.pokemonidzapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.programirex.pokemonidzapi.entity.*;

import java.util.Map;

@Controller
public class registerUser {

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    @ResponseBody
    public User registerUser(@RequestParam(name = "login") String login, @RequestParam(name = "password") String password, @RequestParam(name = "email") String email) {
        return new User(login, password, email);
    }
}