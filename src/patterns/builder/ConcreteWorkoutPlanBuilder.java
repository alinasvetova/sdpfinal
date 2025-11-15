package patterns.builder;

// imports the core objects this builder will use and create
import domain.IExercise;
import domain.SimpleExercise;
import domain.WorkoutPlan;

// the concrete builder implementation
// implements the steps defined in the builder interface
public class ConcreteWorkoutPlanBuilder implements WorkoutPlanBuilder {

    // holds the workout plan being built
    private WorkoutPlan workoutPlan;

    // constructor
    public ConcreteWorkoutPlanBuilder() {
        // the plan is created via the reset method
    }

    @Override
    public void reset(String planName) {
        // creates a new plan object to start building
        this.workoutPlan = new WorkoutPlan(planName);
    }

    @Override
    public void addExercise(IExercise exercise) {
        // adds a pre-existing exercise object to the plan
        if (this.workoutPlan != null) {
            this.workoutPlan.addExercise(exercise);
        }
    }

    @Override
    public void addSimpleExercise(String name, int calories, String equipment) {
        // a helper step to create and add a simple exercise
        if (this.workoutPlan != null) {
            SimpleExercise exercise = new SimpleExercise(name, calories, equipment);
            this.workoutPlan.addExercise(exercise);
        }
    }

    @Override
    public WorkoutPlan getResult() {
        // returns the final, constructed workout plan
        return this.workoutPlan;
    }
}