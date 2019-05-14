package pl.programirex.pokemonidzapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.programirex.pokemonidzapi.entity.User;

@Controller
public class dummyEndpoint2 {
    //@Autowired
    //UsersService usersService;

    @RequestMapping(method = RequestMethod.GET, value = "/getUserByEmail")
    @ResponseBody
    public User getUSerByID(@RequestParam String email) {
        return new User("TestUser1", "12345678", email, "Jan", "Kowalski", 19, 7, (long) 2);
    }
}