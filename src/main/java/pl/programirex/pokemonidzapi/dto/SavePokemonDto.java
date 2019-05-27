package pl.programirex.pokemonidzapi.dto;
import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class SavePokemonDto {
    @Positive
    private Long userId;
    @Positive
    private Long pokemonId;
}
