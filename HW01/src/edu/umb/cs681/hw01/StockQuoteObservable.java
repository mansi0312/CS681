package edu.umb.cs681.hw01;

public class StockQuoteObservable extends Observable{
    public void setQuote(){
        this.setChanged();
    }
}