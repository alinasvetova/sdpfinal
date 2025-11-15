package patterns.builder;

// imports the core objects this builder will use and create
import domain.IExercise;
import domain.WorkoutPlan;

// the builder interface
// defines all the steps to build a workout plan
public interface WorkoutPlanBuilder {

    // resets the builder to start a new plan
    void reset(String planName);

    // adds a single exercise to the plan
    void addExercise(IExercise exercise);

    // a convenience method to add a simple exercise
    void addSimpleExercise(String name, int calories, String equipment);

    // returns the final built workout plan
    WorkoutPlan getResult();
}