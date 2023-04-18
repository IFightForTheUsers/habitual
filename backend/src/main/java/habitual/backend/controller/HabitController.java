package habitual.backend.controller;

import habitual.backend.model.Habit;
import habitual.backend.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @DeleteMapping("/habit/{id}")

}
