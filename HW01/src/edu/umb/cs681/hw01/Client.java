package edu.umb.cs681.hw01;

public class Client{
    public static void main(String[] args){

//        stock
        StockQuoteObservable observable1 = new StockQuoteObservable();
        observable1.addObserver( (Observable o, Object obj) -> {
            System.out.println("1"+ obj);
        });
        observable1.addObserver( (Observable o, Object obj) -> {
            System.out.println("2"+ obj);
        });
        observable1.addObserver( (Observable o, Object obj) -> {
            System.out.println("3"+ obj);
        });

        observable1.setQuote();
        observable1.notifyObservers(new StockEvent("AAA", 198.5f));

//        DJIA
        DJIAQuoteObservable observable2 = new DJIAQuoteObservable();
        observable2.addObserver( (Observable o, Object obj) -> {
            System.out.println("1"+ obj);
        });
        observable2.addObserver( (Observable o, Object obj) -> {
            System.out.println("2"+ obj);
        });
        observable2.addObserver( (Observable o, Object obj) -> {
            System.out.println("3"+ obj);
        });
        observable1.setQuote();
        observable1.notifyObservers(new DJIAEvent(18.5f));

    }
}

class StockEvent{
    private String ticker;
    private float quote;
    public StockEvent(String t, float q){
        this.ticker= t;
        this.quote=q;
    }
    public String getTicker(){
        return ticker;
    }

    public float getQuote(){
        return quote;
    }
}

class DJIAEvent{
    private float djia;

    public float getDjia(){
        return djia;
    }
    public DJIAEvent(float djia){
        this.djia = djia;
    }

    public void setDjia (float djia){
        this.djia = djia;
    }
}