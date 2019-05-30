package com.jms.jmsspringbootactivemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "standalone.queue123")
    public void consume(String message){
        System.out.println("Recieved message: "+message);
    }

}
