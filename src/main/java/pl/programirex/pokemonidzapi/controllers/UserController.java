package pl.programirex.pokemonidzapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.programirex.pokemonidzapi.dto.LoginDto;
import pl.programirex.pokemonidzapi.dto.UserDto;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    @ResponseBody
    public ResponseEntity register(@Valid UserDto accountDto, BindingResult result) {
        User registered = new User();
        if (!result.hasErrors()) {
            registered = userService.saveUser(accountDto);
        }
        if (registered == null || registered.getId() == null) {
            return new ResponseEntity<>("Wystąpił błąd podczas rejestracji", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(registered, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public ResponseEntity login(@Valid LoginDto loginDto, BindingResult result) {
        User logged = new User();
        if (!result.hasErrors()) {
            logged = userService.login(loginDto);
        }
        if (logged == null || logged.getId() == null) {
            return new ResponseEntity<>("Nie udało się zalogować!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(logged, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ResponseEntity<String> test()
    {
        return new ResponseEntity<>("XD", HttpStatus.OK);
    }
}
