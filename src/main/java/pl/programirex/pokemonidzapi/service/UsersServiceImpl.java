package pl.programirex.pokemonidzapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.repository.UsersRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    private static Map<Long, User> userRepo = new HashMap<Long, User>();
    @Autowired
    private UsersRepository usersRepository;

    @PostConstruct
    public void addFirstUser() {
        //var user = new User();

        //user.setLogin("admin");
        //user.setPassword("admin");

        //usersRepository.save(user);
    }

    @Override
    public void createUser(User user) {
        userRepo.put(user.getId(), user);
    }

    @Override
    public void deleteUser(String id) {
        userRepo.remove(id);
    }

    @Override
    public Collection<User> getUsers() {
        return userRepo.values();
    }
}
