package pl.programirex.pokemonidzapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.programirex.pokemonidzapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.email = :email")
    User findByEmail(String email);

    @Query("SELECT u FROM User u where u.login = :login")
    User findByLogin(String login);
}
