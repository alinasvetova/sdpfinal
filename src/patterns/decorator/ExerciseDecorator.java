package patterns.decorator;

// imports the component interface it wraps
import domain.IExercise;
// imports the visitor for the accept method
import patterns.visitor.WorkoutVisitor;

// the abstract decorator class
// implements the component interface (IExercise)
public abstract class ExerciseDecorator implements IExercise {

    // holds the exercise object that is being wrapped
    protected IExercise wrappedExercise;

    // constructor to set the wrapped exercise
    public ExerciseDecorator(IExercise exercise) {
        this.wrappedExercise = exercise;
    }

    // delegates the call to the wrapped exercise
    @Override
    public String getName() {
        return wrappedExercise.getName();
    }

    // delegates the call to the wrapped exercise
    @Override
    public int getCaloriesBurned() {
        return wrappedExercise.getCaloriesBurned();
    }

    // delegates the call to the wrapped exercise
    @Override
    public void perform() {
        wrappedExercise.perform();
    }

    // delegates the accept call to the wrapped exercise
    @Override
    public void accept(WorkoutVisitor visitor) {
        wrappedExercise.accept(visitor);
    }
}