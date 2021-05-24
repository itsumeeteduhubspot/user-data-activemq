package com.project.userActiveMQ.consumer.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.userActiveMQ.model.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/consume")
public class MessageConsumer {

//    Listen at the time of sending in activemq
    /*
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);
    @JmsListener(destination = "user-queue")
    public void messageListener(String users){
        LOGGER.info("User details captured from activemq: "+users);
    }
    */

//    Listen from the list of messages in the queue
    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/users")
    public UserDetails consumeMessage(){
        UserDetails userDetails = null;
        try{
            ObjectMapper getUserDetails = new ObjectMapper();
            String getUsersAsJSON = (String) jmsTemplate.receiveAndConvert("user-queue");
            userDetails = getUserDetails.readValue(getUsersAsJSON, UserDetails.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails;
    }
}
