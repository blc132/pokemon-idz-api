package pl.programirex.pokemonidzapi.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "photoUrl")
    private String photoUrl;

    @Column(name = "wins")
    private int wins;

    @Column(name = "loses")
    private int loses;

    @Column(name = "date_of_the_last_draw")
    private Date dateOfTheLastDraw;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "pwd")
    private String password;

    public User (String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User (String login, String password, String email, Long id) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public User (String login, String password, String email, String firstName, String lastName, int wins, int loses, Long id) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wins = wins;
        this.loses = loses;
        this.id = id;
    }

    public User (String login, String password, String email, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User () {}

    public void setDateOfTheLastDraw(Date dateOfTheLastDraw) {
        this.dateOfTheLastDraw = dateOfTheLastDraw;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public void setDeleted(boolean is_deleted) {
        this.isDeleted = isDeleted;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }
}
