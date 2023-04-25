package habitual.backend.exception;

public class HabitNotFoundException extends RuntimeException{

    public HabitNotFoundException (Integer id) {
        super("Could not find a habit with ID " + id);
    }
}
