package org.gauravj.usr.registration.producer;

import org.springframework.stereotype.Component;

import org.gauravj.usr.registration.model.UserReg;
import org.springframework.kafka.core.KafkaTemplate;

@Component
public class RegProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public RegProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void queueUserReg(UserReg userReg) {
        kafkaTemplate.send("user-reg-topic", userReg.getEmail(), userReg);
    }

    public void queueMessage(String message) {
        kafkaTemplate.send("string-message-topic", message, message);
    }

}
