package pl.programirex.pokemonidzapi.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Battle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User firstUser;

    @ManyToOne
    @JoinColumn
    private User secondUser;

    @Column(name = "first_won")
    private Boolean firstWon;

}
