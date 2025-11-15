package domain;
// imports list utilities
import java.util.ArrayList;
import java.util.List;

// imports the observer interface
import patterns.observer.UserObserver;

// this class holds user data
// it acts as the "subject" in the observer pattern
public class User {

    private String name;
    private double weight;

    // a list of observers to notify
    private List<UserObserver> observers;

    // constructor
    public User(String name, double initialWeight) {
        this.name = name;
        this.weight = initialWeight;
        this.observers = new ArrayList<>();
    }

    // --- observer subject methods ---

    // method to add (subscribe) an observer
    public void addObserver(UserObserver observer) {
        observers.add(observer);
    }

    // method to remove (unsubscribe) an observer
    public void removeObserver(UserObserver observer) {
        observers.remove(observer);
    }

    // the method that notifies all observers
    private void notifyObservers() {
        // passes 'this' (the user object) to the observers
        for (UserObserver observer : observers) {
            observer.update(this);
        }
    }

    // --- business logic ---

    // when setting a new weight, notify observers
    public void setWeight(double newWeight) {
        this.weight = newWeight;
        System.out.println(name + "'s new weight is: " + newWeight + "kg. Notifying observers.");

        // notify all observers about the change
        notifyObservers();
    }

    // --- simple getters ---

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}