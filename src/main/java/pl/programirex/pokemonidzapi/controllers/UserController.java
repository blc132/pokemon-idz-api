package pl.programirex.pokemonidzapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.programirex.pokemonidzapi.dto.GetUserDto;
import pl.programirex.pokemonidzapi.dto.LoginDto;
import pl.programirex.pokemonidzapi.dto.RegisterDto;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.service.UserServiceImpl;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    @ResponseBody
    public ResponseEntity register(@Valid @RequestBody RegisterDto accountDto, BindingResult result) {
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
    public ResponseEntity login(@Valid @RequestBody LoginDto loginDto, BindingResult result) {
        User logged = new User();
        if (!result.hasErrors()) {
            logged = userService.login(loginDto);
        }
        if (logged == null || logged.getId() == null) {
            return new ResponseEntity<>("Nie udało się zalogować!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(logged, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public ResponseEntity getAllUsers() {
        List<GetUserDto> allUsers = userService.getAll().stream()
                .map(user -> new GetUserDto(user.getId(), user.getLogin(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getWins(), user.getLoses()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    @ResponseBody
    public ResponseEntity getById(@PathVariable @NotNull Long userId) {
        User user = userService.getById(userId);
        GetUserDto userDto;
        if(user != null)
        {
            userDto = new GetUserDto(user.getId(), user.getLogin(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getWins(), user.getLoses());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        return  new ResponseEntity<>("Nie znaleziono użytkownika!", HttpStatus.BAD_REQUEST);
    }
}
