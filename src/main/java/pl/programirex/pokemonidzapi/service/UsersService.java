package pl.programirex.pokemonidzapi.service;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.repository.UsersRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface UsersService {
    public abstract void createUser(User user);
    public abstract void deleteUser(String id);
    public abstract Collection<User> getUsers();
}

