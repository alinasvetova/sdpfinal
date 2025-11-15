package patterns.strategy;

// imports the plan this strategy will operate on
import domain.WorkoutPlan;

// the strategy interface
// defines the method that all concrete strategies must implement
public interface WorkoutStrategy {

    // defines the method to execute a specific workout logic
    void execute(WorkoutPlan plan);
}