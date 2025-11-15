package patterns.visitor;

// imports the elements this visitor can visit
import domain.SimpleExercise;
import domain.WorkoutPlan;

// the visitor interface
// defines visit methods for each concrete element type
public interface WorkoutVisitor {

    // defines a visit method for SimpleExercise
    void visit(SimpleExercise exercise);

    // defines a visit method for WorkoutPlan
    void visit(WorkoutPlan plan);
}