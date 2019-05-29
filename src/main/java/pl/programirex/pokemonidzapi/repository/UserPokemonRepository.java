package pl.programirex.pokemonidzapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.programirex.pokemonidzapi.entity.Battle;
import pl.programirex.pokemonidzapi.entity.UserPokemon;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPokemonRepository extends JpaRepository<UserPokemon, Long> {

    @Query("SELECT p FROM UserPokemon p where p.pokemonId = :id")
    UserPokemon findPokemonById(Long id);

    @Query("SELECT p.pokemonId FROM UserPokemon p where p.user.id = :userId")
    List<Long> findUserPokemons(Long userId);
}
