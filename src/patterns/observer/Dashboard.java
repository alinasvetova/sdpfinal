package patterns.observer;

// imports the user class (the subject)
import domain.User;

// a concrete observer that simulates a UI dashboard
public class Dashboard implements UserObserver {

    // implementation of the update method
    @Override
    public void update(User user) {
        // dashboard reacts to the user's data change
        String userName = user.getName();
        double newWeight = user.getWeight();

        // simulates updating a display
        System.out.println("--- Dashboard UI Updated ---");
        System.out.println("User: " + userName);
        System.out.println("Current Weight: " + newWeight + "kg");
        System.out.println("----------------------------");
    }
}