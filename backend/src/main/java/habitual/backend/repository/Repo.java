package habitual.backend.repository;

import habitual.backend.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Habit, Integer> {
}
