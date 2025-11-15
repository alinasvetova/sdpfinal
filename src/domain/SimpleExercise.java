package domain;
// imports the visitor to use it in the accept method
import patterns.visitor.WorkoutVisitor;

// this is a concrete component for the decorator
// it's the base exercise that decorators will wrap
public class SimpleExercise implements IExercise {

    private String name;
    private int caloriesBurned;
    private String equipmentNeeded; // for the equipment visitor

    // constructor to create a simple exercise
    public SimpleExercise(String name, int caloriesBurned, String equipmentNeeded) {
        this.name = name;
        this.caloriesBurned = caloriesBurned;
        this.equipmentNeeded = equipmentNeeded;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCaloriesBurned() {
        return this.caloriesBurned;
    }

    // specific getter for this class, visitors can use it
    public String getEquipmentNeeded() {
        return this.equipmentNeeded;
    }

    @Override
    public void perform() {
        // simulate performing the exercise
        System.out.println("Performing: " + name);
    }

    @Override
    public void accept(WorkoutVisitor visitor) {
        // allows a visitor to process this simple exercise
        // 'this' refers to this instance of SimpleExercise
        visitor.visit(this);
    }
}