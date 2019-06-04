package pl.programirex.pokemonidzapi.service;

import pl.programirex.pokemonidzapi.dto.DeletePokemonDto;
import pl.programirex.pokemonidzapi.dto.GetUserTeamDto;
import pl.programirex.pokemonidzapi.dto.SaveBattleResultDto;
import pl.programirex.pokemonidzapi.dto.SavePokemonDto;
import pl.programirex.pokemonidzapi.entity.UserPokemon;

public interface GameService {
    UserPokemon savePokemon(SavePokemonDto savePokemonDto);
    boolean deletePokemon(DeletePokemonDto savePokemonDto);

    GetUserTeamDto getUserTeam(Long userId);

    boolean saveBattleResult(SaveBattleResultDto saveBattleResultDto);
}
