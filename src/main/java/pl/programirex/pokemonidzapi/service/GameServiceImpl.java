package pl.programirex.pokemonidzapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.programirex.pokemonidzapi.dto.GetUserTeamDto;
import pl.programirex.pokemonidzapi.dto.SavePokemonDto;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.entity.UserPokemon;
import pl.programirex.pokemonidzapi.repository.UserPokemonRepository;
import pl.programirex.pokemonidzapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPokemonRepository userPokemonRepository;


    @Override
    public UserPokemon savePokemon(SavePokemonDto savePokemonDto) {
        if(savePokemonDto.getPokemonId() == null || savePokemonDto.getPokemonId() == 0 || savePokemonDto.getUserId() == null || savePokemonDto.getUserId() == 0)
            return null;

        User user  = userRepository.findById(savePokemonDto.getUserId()).stream().findFirst().orElse(null);

        if(user == null)
            return null;

        UserPokemon userPokemon = new UserPokemon(savePokemonDto.getPokemonId(), user);

        try{
            userPokemonRepository.save(userPokemon);
        }
        catch(Exception e)
        {
            return null;
        }
        return userPokemon;
    }

    @Override
    public GetUserTeamDto getUserTeam(Long userId) {
        User user = userRepository.findById(userId).stream().findFirst().orElse(null);

        if(user == null)
            return null;

        List<Long> pokemonIds = (List<Long>) userPokemonRepository.findUserPokemons(userId);

        GetUserTeamDto userTeam =  new GetUserTeamDto(user.getLogin(), pokemonIds);

        return userTeam;
    }
}
