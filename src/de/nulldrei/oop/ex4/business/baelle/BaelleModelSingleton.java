package de.nulldrei.oop.ex4.business.baelle;

public class BaelleModelSingleton {

    // Static variable to hold the single instance of the object
    private static BaelleModelSingleton instance;

    // The managed object that you want only one instance of
    private final BaelleModel myObject;

    // Private constructor to initialize the single instance
    private BaelleModelSingleton() {
            myObject = new BaelleModel(); // Create the object
    }

        // Static method to provide access to the SingletonObjectManager
    public static synchronized BaelleModelSingleton getInstance() {
        if (instance == null) {
            instance = new BaelleModelSingleton();
        }
        return instance;
    }

    // Public method to get the managed object
    public BaelleModel getObject() {
        return myObject;
    }

}
