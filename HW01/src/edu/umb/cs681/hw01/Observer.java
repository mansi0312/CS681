package edu.umb.cs681.hw01;

@FunctionalInterface
public interface Observer {
    public void update(Observable obs, Object obj);
}