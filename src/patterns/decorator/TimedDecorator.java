package patterns.decorator;

// imports the component interface it wraps
import domain.IExercise;

// a concrete decorator for timed exercises
public class TimedDecorator extends ExerciseDecorator {

    private int durationInSeconds;

    // constructor takes the exercise and the duration
    public TimedDecorator(IExercise exercise, int durationInSeconds) {
        super(exercise);
        this.durationInSeconds = durationInSeconds;
    }

    // override the perform method to add timed behavior
    @Override
    public void perform() {
        // 1. perform the original (e.g., "Get into plank position")
        // in this case, the wrapped name is more like a setup instruction
        System.out.println("Get ready for: " + wrappedExercise.getName());

        // 2. add the new behavior
        System.out.println("...Holding for " + durationInSeconds + " seconds.");
    }

    // override getName to reflect the decoration
    @Override
    public String getName() {
        return wrappedExercise.getName() + " (" + durationInSeconds + "s)";
    }

    // calories for a timed exercise might be different
    @Override
    public int getCaloriesBurned() {
        // calculates calories based on time (e.g., 1 calorie per second)
        // this overrides the wrapped exercise's calories completely
        return durationInSeconds * 1;
    }
}