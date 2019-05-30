package com.jms.jmsspringbootactivemq.resources;

import com.jms.jmsspringbootactivemq.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;


@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String message){
        jmsTemplate.convertAndSend(queue, message);
        return "Published Successfully";
    }

    @GetMapping("/{to}/{message}")
    public String publishMessage(@PathVariable("to") final String to,
                                 @PathVariable("message") final String message){
        // Needed to serialize Email otherwise got below error
        //Cannot convert object of type [com.jms.jmsspringbootactivemq.model.Email] to JMS message. Supported message payloads are: String, byte array, Map<String,?>, Serializable object.
        // Jackson binding pom is commented so not required
        Email email = new Email(to, message);
        jmsTemplate.convertAndSend("email.queue", email); // Can give queue name directly, it will create new queue if not present
        return "Email published";
    }
}
