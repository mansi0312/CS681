package edu.umb.cs681.hw01;
import java.util.LinkedList;

public class Observable {
    private LinkedList<Observer> observers;
    private boolean changed;

    public Observable(){
        observers = new LinkedList<Observer>();
    }

    public void addObserver(Observer o){
        if(o == null) throw new NullPointerException();
        observers.add(o);
    }

    public void deleteObserver(Observer o){
        if(observers.remove(o)){
            System.out.println("Removed");
        }else {
            System.out.println("Observer not exsist");
        }
    }

    protected void setChanged(){
        changed = true;
    }
    protected void clearChanged(){
        changed = false;
    }

    public boolean hasChanged(){
        return changed;
    }

    public void notifyObservers(Object obj){
        if (!changed) {
            return;
        }
        observers.forEach(o -> o.update(this, obj));
        clearChanged();
    }
}