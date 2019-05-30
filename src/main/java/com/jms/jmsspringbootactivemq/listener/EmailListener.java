package com.jms.jmsspringbootactivemq.listener;

import com.jms.jmsspringbootactivemq.model.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {
    /*The JmsListener annotation defines the name of the Destination that this method should listen to and the reference
    to the JmsListenerContainerFactory to use to create the underlying message listener container.*/
    @JmsListener(destination="email.queue")
    public void listenEmail(Email email){
        System.out.println("Listening to email");
        System.out.println(email);
    }
}
