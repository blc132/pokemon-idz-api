package pl.programirex.pokemonidzapi.service;

import pl.programirex.pokemonidzapi.dto.LoginDto;
import pl.programirex.pokemonidzapi.dto.RegisterDto;
import pl.programirex.pokemonidzapi.entity.User;
import java.util.List;

public interface UserService {
    User findUserByEmail(String email);
    User saveUser(RegisterDto user);
    User login(LoginDto loginDto);
    List<User> getAll();
    User getById(Long userId);
}

