package patterns.observer;

// imports the user class (the subject)
import domain.User;

// a concrete observer that checks for achievements
public class AchievementManager implements UserObserver {

    private boolean lostFirstKilo = false;
    private double initialWeight = -1; // -1 indicates not set yet

    // implementation of the update method
    @Override
    public void update(User user) {
        // set the initial weight on first update
        if (initialWeight == -1) {
            this.initialWeight = user.getWeight();
        }

        // check for a specific achievement
        if (!lostFirstKilo && user.getWeight() <= initialWeight - 1) {
            lostFirstKilo = true;

            // simulates unlocking an achievement
            System.out.println("--- Achievement Unlocked! ---");
            System.out.println(user.getName() + " has lost their first kilogram!");
            System.out.println("-----------------------------");
        }
    }
}