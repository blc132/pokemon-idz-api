package pl.programirex.pokemonidzapi.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.programirex.pokemonidzapi.dto.UserDto;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public User findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }


    @Override
    public User saveUser(UserDto userDto){
        if(findUserByEmail(userDto.getEmail()) != null)
            return null;

        User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getEmail(), userDto.getFirstName(), userDto.getLastName());
        user.setDeleted(false);
        user.setDateOfTheLastDraw(getCurrentDate());
        user.setWins(0);
        user.setLoses(0);
        try{
            usersRepository.save(user);
        }
        catch(Exception e)
        {
            return null;
        }
        return user;
    }

    private Date getCurrentDate()
    {
        return new java.sql.Timestamp(new java.util.Date().getTime());
    }
}
