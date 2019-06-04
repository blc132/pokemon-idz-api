package pl.programirex.pokemonidzapi.dto.game;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetUserTeamDto {

    public GetUserTeamDto(String login, List<Long> pokemonIds, Long mainPokemonId)
    {
        this.login = login;
        this.pokemonIds = pokemonIds;
        this.mainPokemonId = mainPokemonId;
    }

    @NotNull
    private String login;

    @NotNull
    private List<Long> pokemonIds;

    private Long mainPokemonId;
}
