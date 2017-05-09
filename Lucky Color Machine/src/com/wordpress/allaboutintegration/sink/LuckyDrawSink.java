package com.wordpress.allaboutintegration.sink;

import com.bea.wlevs.ede.api.EventRejectedException;
import com.bea.wlevs.ede.api.StreamSink;

import com.wordpress.allaboutintegration.event.WinnerEvent;

import java.util.List;

public class LuckyDrawSink implements StreamSink{
    public LuckyDrawSink() {
        super();
    }

    @Override
    public void onInsertEvent(Object event) throws EventRejectedException {
        if (event instanceof WinnerEvent) {
            WinnerEvent insertedEvent = (WinnerEvent) event ;
            System.out.println(insertedEvent.toString()); 
        }
    }
}
