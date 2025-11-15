package patterns.observer;

// imports the user class (the subject)
import domain.User;

// the observer interface
// defines the method that all observers must implement
public interface UserObserver {

    // the update method called by the subject (user)
    void update(User user);
}