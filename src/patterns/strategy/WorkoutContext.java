package patterns.strategy;

// imports the plan this context will manage
import domain.WorkoutPlan;

// this is the context class for the strategy pattern
// it holds a reference to a strategy object
public class WorkoutContext {

    // holds the current strategy
    private WorkoutStrategy strategy;
    private WorkoutPlan plan;

    // constructor to set the context
    public WorkoutContext(WorkoutPlan plan) {
        this.plan = plan;
        // a default strategy can be set here, or set later
    }

    // allows changing the strategy at runtime
    public void setStrategy(WorkoutStrategy strategy) {
        this.strategy = strategy;
    }

    // executes the currently set strategy
    public void executeWorkout() {
        if (strategy == null) {
            System.out.println("Please set a strategy first.");
            return;
        }
        // delegates the execution to the strategy object
        strategy.execute(this.plan);
    }
}