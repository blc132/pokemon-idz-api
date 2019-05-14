package pl.programirex.pokemonidzapi.service;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.repository.UsersRepository;

import javax.annotation.PostConstruct;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    @PostConstruct
    public void addFirstUser() {
        var user = new User();

        user.setLogin("admin");
        user.setPassword("admin");

        usersRepository.save(user);
    }

}
