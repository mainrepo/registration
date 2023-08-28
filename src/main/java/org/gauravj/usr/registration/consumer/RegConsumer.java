package org.gauravj.usr.registration.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Date;
import org.gauravj.usr.registration.model.UserReg;

@Slf4j
@Component
public class RegConsumer {
    @KafkaListener(topics = "user-reg-topic", properties = {"spring.json.value.default.type=org.gauravj.usr.registration.model.UserReg"})
    public void userRegTopicListener(UserReg userReg, Acknowledgment acknowledgment) {
        log.info("Received a user message {}, date {}", userReg, new Date());
        acknowledgment.acknowledge();
    }

    @KafkaListener(topics = "string-message-topic", properties = {"spring.json.value.default.type=java.lang.String"})
    public void stringTopicListener(String message, Acknowledgment acknowledgment) {

        log.info("Received a string message {}, date {}", message, new Date());
        acknowledgment.acknowledge();
    }
}
