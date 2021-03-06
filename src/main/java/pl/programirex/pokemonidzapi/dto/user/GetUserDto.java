package pl.programirex.pokemonidzapi.dto.user;

import lombok.Data;

@Data
public class GetUserDto {

    public GetUserDto(Long id, String login, String firstName, String lastName, String email, int wins, int loses)   {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.loses = loses;
        this.wins = wins;
    }

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

    private String email;

    private int loses;

    private int wins;
}
