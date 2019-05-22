package pl.programirex.pokemonidzapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.programirex.pokemonidzapi.entity.Battle;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Long> {
}
