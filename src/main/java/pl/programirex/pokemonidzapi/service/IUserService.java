package pl.programirex.pokemonidzapi.service;

import pl.programirex.pokemonidzapi.dto.UserDto;
import pl.programirex.pokemonidzapi.entity.User;

public interface IUserService {
    User findUserByEmail(String email);
    User saveUser(UserDto user);
}

