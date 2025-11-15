package patterns.visitor;

// imports the elements this visitor can visit
import domain.SimpleExercise;
import domain.WorkoutPlan;

// a concrete visitor for calculating total calories
public class CalorieCalculatorVisitor implements WorkoutVisitor {

    // holds the total calories calculated
    private int totalCalories = 0;

    // this method is called when the visitor visits a simple exercise
    @Override
    public void visit(SimpleExercise exercise) {
        // adds the exercise's calories to the total
        this.totalCalories += exercise.getCaloriesBurned();
    }

    // this method is called when the visitor visits a workout plan
    @Override
    public void visit(WorkoutPlan plan) {
        // the visit to the plan itself doesn't add calories
        // it just prints a message
        System.out.println("Calculating calories for plan: " + plan.getPlanName());
    }

    // a helper method to get the final result
    public int getTotalCalories() {
        return this.totalCalories;
    }
}