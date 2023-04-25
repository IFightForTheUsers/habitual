package habitual.backend.controller;

import habitual.backend.exception.HabitNotFoundException;
import habitual.backend.model.Habit;
import habitual.backend.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class HabitController {

    @Autowired
    private Repo habitRepo;

    @PostMapping("/habit")
    Habit newHabit(@RequestBody Habit newHabit) {
        return habitRepo.save(newHabit);
    }

    @GetMapping("/habits")
    List<Habit> getAllHabits() {
        return habitRepo.findAll();
    }

    @DeleteMapping("/habit/{id}")
    String deleteHabit(@PathVariable Integer id) {
        if (habitRepo.existsById(id)){
            habitRepo.deleteById(id);
            return "Habit with id " + id + " has been deleted.";
        }
        else {
            throw new HabitNotFoundException(id);
        }

    }

    @GetMapping("/habit/{id}")
    Habit getHabitById(@PathVariable Integer id) {
        return habitRepo.findById(id)
                .orElseThrow(()-> new HabitNotFoundException(id));
    }

    @PutMapping("/habit/{id}")
    Habit updateHabit(@RequestBody Habit updatedHabit, @PathVariable Integer id) {
        return habitRepo.findById(id).map(habit -> {
            habit.setName(updatedHabit.getName());
            return habitRepo.save(habit);
        }).orElseThrow(() -> new HabitNotFoundException(id));
    }

}
