package com.example.activemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author AJ Catambay of Bridging Code
 *
 */
@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "bridgingcode-queue1")
    public void messageListener(String systemMessage) {
        LOGGER.info("Message received in service B! {}", systemMessage);
    }
}