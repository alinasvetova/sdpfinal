package patterns.decorator; //

// imports the component interface
import domain.IExercise;

// a concrete decorator for adding an extra set
public class ExtraSetDecorator extends ExerciseDecorator {

    // constructor passes the exercise to the parent decorator
    public ExtraSetDecorator(IExercise exercise) {
        super(exercise);
    }

    // override the perform method to add new behavior
    @Override
    public void perform() {
        // 1. perform the original exercise
        wrappedExercise.perform();

        // 2. add the new behavior
        System.out.println("...Adding one extra set!");
    }

    // override getName to reflect the decoration
    @Override
    public String getName() {
        return wrappedExercise.getName() + " (with Extra Set)";
    }

    // calories might increase with an extra set
    @Override
    public int getCaloriesBurned() {
        // adds 50% more calories for the extra set (just an example)
        return (int) (wrappedExercise.getCaloriesBurned() * 1.5);
    }
}