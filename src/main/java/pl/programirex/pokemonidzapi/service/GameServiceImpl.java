package pl.programirex.pokemonidzapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.programirex.pokemonidzapi.dto.DeletePokemonDto;
import pl.programirex.pokemonidzapi.dto.GetUserTeamDto;
import pl.programirex.pokemonidzapi.dto.SaveBattleResultDto;
import pl.programirex.pokemonidzapi.dto.SavePokemonDto;
import pl.programirex.pokemonidzapi.entity.User;
import pl.programirex.pokemonidzapi.entity.UserPokemon;
import pl.programirex.pokemonidzapi.repository.UserPokemonRepository;
import pl.programirex.pokemonidzapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPokemonRepository userPokemonRepository;


    @Override
    public UserPokemon savePokemon(SavePokemonDto savePokemonDto) {
        if (savePokemonDto.getPokemonId() == null || savePokemonDto.getPokemonId() == 0 || savePokemonDto.getUserId() == null || savePokemonDto.getUserId() == 0)
            return null;

        User user = userRepository.findById(savePokemonDto.getUserId()).stream().findFirst().orElse(null);

        if (user == null)
            return null;

        UserPokemon userPokemon = new UserPokemon(savePokemonDto.getPokemonId(), user);

        try {
            userPokemonRepository.save(userPokemon);
        } catch (Exception e) {
            return null;
        }
        return userPokemon;
    }

    @Override
    public boolean deletePokemon(DeletePokemonDto deletePokemonDto) {
        if (deletePokemonDto.getPokemonId() == null || deletePokemonDto.getPokemonId() == 0 || deletePokemonDto.getUserId() == null || deletePokemonDto.getUserId() == 0)
            return false;

        User user = userRepository.findById(deletePokemonDto.getUserId()).stream().findFirst().orElse(null);

        if (user == null)
            return false;

        UserPokemon userPokemon = userPokemonRepository.findUserPokemon(user.getId(), deletePokemonDto.getPokemonId()).stream().findFirst().orElse(null);

        try {
            userPokemonRepository.delete(userPokemon);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public GetUserTeamDto getUserTeam(Long userId) {
        User user = userRepository.findById(userId).stream().findFirst().orElse(null);

        if (user == null)
            return null;

        List<Long> pokemonIds = userPokemonRepository.findUserPokemons(userId);

        GetUserTeamDto userTeam = new GetUserTeamDto(user.getLogin(), pokemonIds);

        return userTeam;
    }

    @Override
    public boolean saveBattleResult(SaveBattleResultDto saveBattleResultDto) {
        if (saveBattleResultDto.getUserId() == null || saveBattleResultDto.getUserId() == 0 || saveBattleResultDto.getWon() == null)
            return false;

        User user = userRepository.findById(saveBattleResultDto.getUserId()).stream().findFirst().orElse(null);

        if (user == null)
            return false;

        if (saveBattleResultDto.getWon()) {
            int wins = user.getWins() + 1;
            user.setWins(wins);
        } else if (!saveBattleResultDto.getWon()) {
            int loses = user.getLoses() + 1;
            user.setLoses(loses);
        }

        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
