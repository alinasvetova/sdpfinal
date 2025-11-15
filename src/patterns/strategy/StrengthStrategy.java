package patterns.strategy;

// imports the plan this strategy will operate on
import domain.WorkoutPlan;

// a concrete strategy for strength training
public class StrengthStrategy implements WorkoutStrategy {

    @Override
    public void execute(WorkoutPlan plan) {
        // simulates the logic for a strength workout
        System.out.println("Starting STRENGTH workout: " + plan.getPlanName());
        System.out.println("Focus: low reps, high weight, long rest.");

        // execute the actual plan exercises
        plan.executePlan();

        System.out.println("Finished STRENGTH workout.");
    }
}