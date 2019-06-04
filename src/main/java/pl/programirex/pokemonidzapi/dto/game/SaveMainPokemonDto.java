package pl.programirex.pokemonidzapi.dto.game;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class SaveMainPokemonDto {

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    @Positive
    private Long mainPokemonId;
}
