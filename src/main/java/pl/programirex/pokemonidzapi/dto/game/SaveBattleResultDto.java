package pl.programirex.pokemonidzapi.dto.game;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class SaveBattleResultDto {

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    private Boolean won;
}
