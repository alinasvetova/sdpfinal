package domain;
// imports list utilities
import java.util.ArrayList;
import java.util.List;

// imports the visitor interface
import patterns.visitor.WorkoutVisitor;

// this class is a container for exercises
// it also acts as a composite element for the visitor pattern
public class WorkoutPlan implements WorkoutElement {

    private String planName;
    // a workout plan consists of a list of exercises
    private List<IExercise> exercises;

    // constructor
    public WorkoutPlan(String planName) {
        this.planName = planName;
        this.exercises = new ArrayList<>();
    }

    // method to add an exercise to the plan
    public void addExercise(IExercise exercise) {
        exercises.add(exercise);
    }

    // getter for the list of exercises
    public List<IExercise> getExercises() {
        return exercises;
    }

    public String getPlanName() {
        return planName;
    }

    // executes all exercises in the plan
    public void executePlan() {
        System.out.println("--- Starting Workout Plan: " + planName + " ---");
        for (IExercise exercise : exercises) {
            exercise.perform();
        }
        System.out.println("--- Workout Plan Finished ---");
    }

    @Override
    public void accept(WorkoutVisitor visitor) {
        // the visitor first visits the plan itself
        visitor.visit(this);

        // then the visitor visits all exercises in the plan
        for (IExercise exercise : exercises) {
            // this calls the accept method on each exercise (SimpleExercise or Decorator)
            exercise.accept(visitor);
        }
    }
}