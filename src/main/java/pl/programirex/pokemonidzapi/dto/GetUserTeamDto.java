package pl.programirex.pokemonidzapi.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetUserTeamDto {

    public GetUserTeamDto(String login, List<Long> pokemonIds)
    {
        this.login = login;
        this.pokemonIds = pokemonIds;
    }

    @NotNull
    private String login;

    @NotNull
    private List<Long> pokemonIds;
}
