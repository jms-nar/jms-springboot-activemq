package com.jms.jmsspringbootactivemq.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class Consumer {

    @JmsListener(destination = "standalone.queue123")
    public void consume(String message){
        System.out.println("Recieved message: "+message);
    }

}
