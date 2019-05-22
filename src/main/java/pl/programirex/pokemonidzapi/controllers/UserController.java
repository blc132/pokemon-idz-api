package pl.programirex.pokemonidzapi.controllers;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import pl.programirex.pokemonidzapi.dto.UserDto;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

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

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ResponseEntity<String> test()
    {
        return new ResponseEntity<>("XD", HttpStatus.OK);
    }
}
