package com.wordpress.allaboutintegration.event;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WinnerEvent {
    
    private String information; 
        
    private int winnerRollNumber ; 
    
    public WinnerEvent() {
        super();
    }

    public void setWinnerRollNumber(int winnerRollNumber) {
        this.winnerRollNumber = winnerRollNumber;
    }

    public int getWinnerRollNumber() {
        return winnerRollNumber;
    }
    
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentTime = new Date();
        return "Winner found with the score:: "+ this.getInformation() + " :"+ this.getWinnerRollNumber()  + " at " + df.format(currentTime); 
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }
}
