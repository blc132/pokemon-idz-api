package pl.programirex.pokemonidzapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.programirex.pokemonidzapi.entity.Battle;
import pl.programirex.pokemonidzapi.entity.UserPokemon;

@Repository
public interface UserPokemonRepository extends JpaRepository<UserPokemon, Long> {
}
