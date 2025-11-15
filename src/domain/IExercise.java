package domain;
// this is the component interface for the decorator pattern
// it also extends WorkoutElement to be part of the visitor pattern
public interface IExercise extends WorkoutElement {

    // all exercises must have a name
    String getName();

    // all exercises must have a method to get calories
    int getCaloriesBurned();

    // main method to perform the exercise
    void perform();
}