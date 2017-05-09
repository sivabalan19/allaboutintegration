package com.wordpress.allaboutintegration.adaptor;

import com.bea.wlevs.ede.api.StreamSender;
import com.bea.wlevs.ede.api.StreamSource;

import com.wordpress.allaboutintegration.event.LuckyDraw;

import java.util.Random;

public class  JackpotMachineAdaptor implements Runnable, StreamSource{
    
    private static final int sleepTime = 100; // sleep time in milli-sec.
    
    private int luckyNumber ;
    
    private enum_luckyColor luckyColor; 
    
    private enum enum_luckyColor {
        RED, GREEN, BLUE, BLACK, WHITE, YELLOW ; 
    }
    
    private boolean stop  = true; // traffic light to stop the event sender... 
    
    private StreamSender eventSender;  // the remote control to control the flow of the events... 
    
    public JackpotMachineAdaptor() {
        super();
    }
    
    public  void run() {
        while (this.stop) { // this traffic light never changes.. Haha ! 
            publish_luckyDraw();
            try {
                synchronized (this) {
                    wait(sleepTime);
                } 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
    public void setEventSender(StreamSender streamSender) {
        this.eventSender = streamSender; 
    }
    
    public void publish_luckyDraw() {
        this.luckyNumber = (int) (Math.random() * 50 + 1) ;  // generate a random number..
        this.luckyColor = getLuckyColor(); // get a random color
        //System.out.println("sending the lucky number : " + this.luckyNumber + ": " + this.luckyColor.name());
        LuckyDraw _my_draw = new LuckyDraw(this.luckyNumber, this.luckyColor.name());
        eventSender.sendInsertEvent(_my_draw); // i am publishing my draw..
    }
    
    public enum_luckyColor getLuckyColor() {
        int randint = (int) (Math.random() * enum_luckyColor.values().length);
        return enum_luckyColor.values()[randint];
    }
    
}
