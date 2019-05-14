package pl.programirex.pokemonidzapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.programirex.pokemonidzapi.entity.*;
import pl.programirex.pokemonidzapi.service.UsersService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Controller
public class getAll {
    @Autowired
    UsersService usersService;

    ArrayList<User> list = new ArrayList<User>();
    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public ArrayList<User> getEm() {
        list.add(new User("TestUser1", "12345678", "mail@mail.mail", "Jan", "Kowalski", 19, 7, (long) 2));
        list.add(new User("TestUser2", "haslohaslo", "email@email.email", "Anna", "Nowak", 3, 15, (long) 1));

        return list;
    }
}