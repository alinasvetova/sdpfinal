package patterns.strategy;

// imports the plan this strategy will operate on
import domain.WorkoutPlan;

// a concrete strategy for cardio training
public class CardioStrategy implements WorkoutStrategy {

    @Override
    public void execute(WorkoutPlan plan) {
        // simulates the logic for a cardio workout
        System.out.println("Starting CARDIO workout: " + plan.getPlanName());
        System.out.println("Focus: high heart rate, constant movement.");

        // execute the actual plan exercises
        plan.executePlan();

        System.out.println("Finished CARDIO workout.");
    }
}