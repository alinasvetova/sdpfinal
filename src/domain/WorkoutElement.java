package domain;
import patterns.visitor.WorkoutVisitor;

// element interface for the visitor pattern
// classes that implement this can be "visited"
public interface WorkoutElement {

    // defines the accept method that takes a visitor
    void accept(WorkoutVisitor visitor);
}