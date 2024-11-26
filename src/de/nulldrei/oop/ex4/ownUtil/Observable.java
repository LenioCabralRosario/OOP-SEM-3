package de.nulldrei.oop.ex4.ownUtil;

public interface Observable {

    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

}