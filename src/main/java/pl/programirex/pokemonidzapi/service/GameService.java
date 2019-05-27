package pl.programirex.pokemonidzapi.service;

import pl.programirex.pokemonidzapi.dto.SavePokemonDto;
import pl.programirex.pokemonidzapi.entity.UserPokemon;

public interface GameService {
    UserPokemon savePokemon(SavePokemonDto savePokemonDto);
}
