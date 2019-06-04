package pl.programirex.pokemonidzapi.dto.game;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class DeletePokemonDto {
    @Positive
    private Long userId;
    @Positive
    private Long pokemonId;
}
