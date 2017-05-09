package com.wordpress.allaboutintegration.event;

public class LuckyDraw {
    
    private int luckyNumber ;
    
    private String luckyColor;

    public void setLuckyColor(String luckyColor) {
        this.luckyColor = luckyColor;
    }

    public String getLuckyColor() {
        return luckyColor;
    }

    public void setLuckyNumber(int luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    public LuckyDraw() {
        super();
    }
    
    public LuckyDraw(int i, String c) {
        this.luckyNumber = i ; 
        this.luckyColor = c ;
    }
    
    @Override
    public String toString() {
        return "your lucky draw : " + getLuckyColor() + " : "+ getLuckyNumber() ; 
    }
}
