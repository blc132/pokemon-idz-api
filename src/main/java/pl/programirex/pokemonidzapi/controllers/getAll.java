package pl.programirex.pokemonidzapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.programirex.pokemonidzapi.entity.*;
import pl.programirex.pokemonidzapi.service.UsersService;
import java.util.Collection;
import java.util.Map;

@Controller
public class getAll {
    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public Collection<User> getEm() {
        return usersService.getUsers();
    }
}