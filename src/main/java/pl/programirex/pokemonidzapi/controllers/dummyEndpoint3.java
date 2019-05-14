package pl.programirex.pokemonidzapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

//import pl.programirex.pokemonidzapi.service.UsersService;

@Controller
public class dummyEndpoint3 {
    ArrayList<String> list = new ArrayList<String>();


    @RequestMapping(method = RequestMethod.GET, value = "/getAllUserPokemons")
    @ResponseBody
    public ArrayList<String> getEm(@RequestParam Long id) {
        list.add("Bulbasaur");
        list.add("Greninja");
        list.add("Incineroar");
        return list;
    }
}