package pl.programirex.pokemonidzapi.service;

import pl.programirex.pokemonidzapi.dto.LoginDto;
import pl.programirex.pokemonidzapi.dto.UserDto;
import pl.programirex.pokemonidzapi.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    User saveUser(UserDto user);
    User login(LoginDto loginDto);
}

