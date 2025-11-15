package patterns.visitor;

// imports list utilities
import java.util.HashSet;
import java.util.Set;

// imports the elements this visitor can visit
import domain.SimpleExercise;
import domain.WorkoutPlan;

// a concrete visitor for gathering required equipment
public class EquipmentListVisitor implements WorkoutVisitor {

    // using a set to avoid duplicate equipment names
    private Set<String> equipmentList;

    // constructor
    public EquipmentListVisitor() {
        this.equipmentList = new HashSet<>();
    }

    // this method is called when the visitor visits a simple exercise
    @Override
    public void visit(SimpleExercise exercise) {
        String equipment = exercise.getEquipmentNeeded();
        // adds the exercise's equipment to the list
        // ignores "none" or empty equipment
        if (equipment != null && !equipment.isEmpty() && !equipment.equalsIgnoreCase("none")) {
            this.equipmentList.add(equipment);
        }
    }

    // this method is called when the visitor visits a workout plan
    @Override
    public void visit(WorkoutPlan plan) {
        // the visit to the plan itself doesn't add equipment
        // it just prints a message
        System.out.println("Checking equipment for plan: " + plan.getPlanName());
    }

    // a helper method to get the final result
    public Set<String> getEquipmentList() {
        return this.equipmentList;
    }
}