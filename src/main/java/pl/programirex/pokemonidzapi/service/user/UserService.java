package pl.programirex.pokemonidzapi.service.user;

import pl.programirex.pokemonidzapi.dto.user.LoginDto;
import pl.programirex.pokemonidzapi.dto.user.RegisterDto;
import pl.programirex.pokemonidzapi.entity.User;
import java.util.List;

public interface UserService {
    User findUserByEmail(String email);
    User saveUser(RegisterDto user);
    User login(LoginDto loginDto);
    List<User> getAll();
    User getById(Long userId);
}

