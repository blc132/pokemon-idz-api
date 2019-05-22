package pl.programirex.pokemonidzapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.programirex.pokemonidzapi.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
