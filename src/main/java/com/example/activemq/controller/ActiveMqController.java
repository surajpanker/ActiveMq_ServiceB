package com.example.activemq.controller;

import com.example.activemq.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveMqController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/addMessage")
    @ResponseBody
    public String  addMessageIntoQueue(@RequestBody  Request req){
        try{
            jmsTemplate.convertAndSend("bridgingcode-queue",req.getMessage());

            return "test    ->  --->   "+req.getMessage();
        }catch (
               Exception E
        ){
            E.printStackTrace();
            return E.toString();
        }


    }

}
