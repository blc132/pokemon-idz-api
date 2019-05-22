package pl.programirex.pokemonidzapi.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
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

    public User () {}

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    //@Override
//    //public String getPassword() {
//    //    return getPassword();
//    //}
//
//    public String getId(){
//        return id.toString();
//    }
//
//    @Override
//    public String getUsername() { return getLogin(); }
//
//    private String getLogin() {
//        return this.login;
//    }
//
//    //uproszczenie, nie robimy tego
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    //uproszczenie, nie robimy tego
//    @Override
//    public boolean isAccountNonLocked() {
//        return true ;
//    }
//
//    //uproszczenie, nie robimy tego
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
