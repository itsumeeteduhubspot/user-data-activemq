package com.project.userActiveMQ.publisher.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.userActiveMQ.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/users")
    public UserDetails publishMessage(@RequestBody UserDetails userDetails) {
        try {
            ObjectMapper sendUserDetails = new ObjectMapper();
            String userAsJson = sendUserDetails.writeValueAsString(userDetails);
            jmsTemplate.convertAndSend("user-queue", userAsJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails;
    }
}
