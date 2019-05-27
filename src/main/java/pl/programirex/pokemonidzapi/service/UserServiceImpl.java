package pl.programirex.pokemonidzapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.programirex.pokemonidzapi.dto.LoginDto;
import pl.programirex.pokemonidzapi.dto.RegisterDto;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.repository.UserRepository;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public User findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }


    @Override
    public User saveUser(RegisterDto userDto){
        if(findUserByEmail(userDto.getEmail()) != null)
            return null;

        User user = new User(userDto.getLogin(), BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(8)), userDto.getEmail(), userDto.getFirstName(), userDto.getLastName());
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

    @Override
    public User login(LoginDto loginDto) {
        User user = usersRepository.findByLogin(loginDto.getLogin());
        if(user == null)
            return null;
        if(BCrypt.checkpw(loginDto.getPassword(), user.getPassword()))
            return user;
        return null;
    }

    @Override
    public List<User> getAll() {
        return usersRepository.findAll();

    }

    @Override
    public User getById(Long userId) {
       return usersRepository.findById(userId).stream().findFirst().orElse(null);
    }

    private Date getCurrentDate()
    {
        return new java.sql.Timestamp(new java.util.Date().getTime());
    }
}
