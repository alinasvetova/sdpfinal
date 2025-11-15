package main;

// imports all the domain objects
import domain.IExercise;
import domain.WorkoutPlan;
import domain.SimpleExercise; // imported for manual decoration

// imports all 6 patterns (or their key classes)
import patterns.facade.FitnessFacade;
import patterns.strategy.WorkoutContext;
import patterns.strategy.StrengthStrategy;
import patterns.strategy.CardioStrategy;
import patterns.decorator.ExtraSetDecorator;
import patterns.decorator.TimedDecorator;
// builder, observer, visitor are used *inside* the facade

// imports for utility
import java.util.Set;

// the main class to run the application
public class Main {

    public static void main(String[] args) {

        System.out.println("--- 1. Initializing System (Facade, Observer) ---");

        // facade initializes user and registers observers (dashboard, achievements)
        FitnessFacade fitnessApp = new FitnessFacade("Amina", 70.0);

        System.out.println("\n--- 2. Simulating Weight Change (Observer) ---");
        // updating weight triggers dashboard and achievement manager
        fitnessApp.updateUserWeight(68.5);

        System.out.println("\n--- 3. Creating Workout Plan (Builder) ---");
        // facade uses the builder to create a complex plan
        WorkoutPlan myPlan = fitnessApp.createFullBodyWorkout();

        System.out.println("Plan '" + myPlan.getPlanName() + "' created.");

        System.out.println("\n--- 4. Applying Decorators ---");
        // we can modify the plan *after* it's built

        // 4.1. get the "Plank" exercise from the plan (it's the 4th one)
        IExercise plank = myPlan.getExercises().get(3);

        // 4.2. decorate it with a timer
        IExercise timedPlank = new TimedDecorator(plank, 60); // 60 seconds

        // 4.3. get the "Push-ups" (1st one) and add an extra set
        IExercise pushups = myPlan.getExercises().get(0);
        IExercise extraPushups = new ExtraSetDecorator(pushups);

        // 4.4. update the plan with the decorated exercises
        myPlan.getExercises().set(0, extraPushups); // replace original pushups
        myPlan.getExercises().set(3, timedPlank); // replace original plank

        System.out.println("Decorated 'Push-ups' with extra set.");
        System.out.println("Decorated 'Plank' with 60s timer.");

        System.out.println("\n--- 5. Analyzing Plan (Visitor) ---");
        // facade uses visitors to get data from the plan

        // 5.1. calorie visitor (note: calories will be higher due to decorators)
        int calories = fitnessApp.calculatePlanCalories(myPlan);
        System.out.println("Total plan calories (with decorators): " + calories);

        // 5.2. equipment visitor
        Set<String> equipment = fitnessApp.getPlanEquipment(myPlan);
        System.out.println("Total equipment needed: " + equipment);

        System.out.println("\n--- 6. Executing Plan (Strategy) ---");

        // 6.1. create a context for our plan
        WorkoutContext workout = new WorkoutContext(myPlan);

        // 6.2. execute with strength strategy
        workout.setStrategy(new StrengthStrategy());
        workout.executeWorkout();

        // 6.3. execute the *same* plan with cardio strategy
        System.out.println("--- (Switching Strategy) ---");
        workout.setStrategy(new CardioStrategy());
        workout.executeWorkout();

        System.out.println("\n--- Project Demo Finished ---");
    }
}