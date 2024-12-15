package de.nulldrei.oop.ex5.ownUtil;

public interface Observable {

    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();

}
