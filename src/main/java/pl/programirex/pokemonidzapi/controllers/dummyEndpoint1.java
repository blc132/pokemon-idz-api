package pl.programirex.pokemonidzapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.programirex.pokemonidzapi.entity.User;

@Controller
public class dummyEndpoint1 {
    //@Autowired
    //UsersService usersService;

    @RequestMapping(method = RequestMethod.GET, value = "/getUserById")
    @ResponseBody
    public User getUSerByID(@RequestParam Long id) {
        return new User("TestUser2", "haslohaslo", "email@email.email", "Anna", "Nowak", 3, 15, id);
    }
}