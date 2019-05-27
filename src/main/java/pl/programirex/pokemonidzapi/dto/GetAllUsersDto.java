package pl.programirex.pokemonidzapi.dto;

import lombok.Data;

@Data
public class GetAllUsersDto {

    public GetAllUsersDto(Long id, String login, String firstName, String lastName, String email, int loses, int wins)   {
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
