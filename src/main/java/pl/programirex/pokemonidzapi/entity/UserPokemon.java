package pl.programirex.pokemonidzapi.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserPokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "pokemon_id")
    private Long pokemonId;

    @ManyToOne
    @JoinColumn
    private User user;

}
