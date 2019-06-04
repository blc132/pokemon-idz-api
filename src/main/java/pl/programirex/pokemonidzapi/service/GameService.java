package pl.programirex.pokemonidzapi.service;

import pl.programirex.pokemonidzapi.dto.*;
import pl.programirex.pokemonidzapi.entity.UserPokemon;

public interface GameService {
    UserPokemon savePokemon(SavePokemonDto savePokemonDto);
    boolean deletePokemon(DeletePokemonDto savePokemonDto);

    GetUserTeamDto getUserTeam(Long userId);

    boolean saveBattleResult(SaveBattleResultDto saveBattleResultDto);

    boolean saveMainPokemon(SaveMainPokemonDto saveMainPokemonDto);
}
