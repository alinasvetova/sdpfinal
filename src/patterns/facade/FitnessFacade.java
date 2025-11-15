package patterns.facade;

// imports list utilities
import java.util.List;
import java.util.Set;

// imports all domain objects
import domain.IExercise;
import domain.User;
import domain.WorkoutPlan;

// imports the patterns this facade will simplify
import patterns.builder.ConcreteWorkoutPlanBuilder;
import patterns.builder.WorkoutPlanBuilder;
import patterns.observer.Dashboard;
import patterns.observer.AchievementManager;
import patterns.visitor.CalorieCalculatorVisitor;
import patterns.visitor.EquipmentListVisitor;

// the facade class
// provides a simplified interface to the complex fitness system
public class FitnessFacade {

    private User user;
    private WorkoutPlanBuilder planBuilder;
    private Dashboard dashboard; // one of the observers
    private AchievementManager achievementManager; // another observer

    // constructor initializes the subsystems
    public FitnessFacade(String userName, double initialWeight) {
        // create the user (the observer subject)
        this.user = new User(userName, initialWeight);

        // create the builder
        this.planBuilder = new ConcreteWorkoutPlanBuilder();

        // create and register observers
        this.dashboard = new Dashboard();
        this.achievementManager = new AchievementManager();
        this.user.addObserver(dashboard);
        this.user.addObserver(achievementManager);
    }

    // a simple method to create a full body workout plan
    public WorkoutPlan createFullBodyWorkout() {
        // uses the builder to create a complex object
        planBuilder.reset("Full Body Basic");
        planBuilder.addSimpleExercise("Push-ups", 10, "none");
        planBuilder.addSimpleExercise("Squats", 15, "none");
        planBuilder.addSimpleExercise("Dumbbell Rows", 20, "dumbbells");
        planBuilder.addSimpleExercise("Plank", 5, "none"); // calories will be fixed by decorator
        return planBuilder.getResult();
    }

    // a simple method to update the user's weight
    // this will trigger the observer pattern
    public void updateUserWeight(double newWeight) {
        this.user.setWeight(newWeight);
    }

    // a simple method to get calorie count
    // this will use the visitor pattern
    public int calculatePlanCalories(WorkoutPlan plan) {
        CalorieCalculatorVisitor calorieVisitor = new CalorieCalculatorVisitor();
        plan.accept(calorieVisitor);
        return calorieVisitor.getTotalCalories();
    }

    // a simple method to get equipment list
    // this will use the visitor pattern
    public Set<String> getPlanEquipment(WorkoutPlan plan) {
        EquipmentListVisitor equipmentVisitor = new EquipmentListVisitor();
        plan.accept(equipmentVisitor);
        return equipmentVisitor.getEquipmentList();
    }

    // simple getter for the user
    public User getUser() {
        return this.user;
    }
}