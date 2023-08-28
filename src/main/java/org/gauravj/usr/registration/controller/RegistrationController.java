package org.gauravj.usr.registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.http.ResponseEntity;
import org.gauravj.usr.registration.model.UserReg;
import org.gauravj.usr.registration.producer.RegProducer;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private static final DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    private final RegProducer regProducer;

    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody UserReg userReg) {
        regProducer.queueMessage("/api/register::register:attempt");
        userReg.setCreated(df.format(Calendar.getInstance().getTime()));
        regProducer.queueUserReg(userReg);
        log.info("/api/register::register:success");
        return ResponseEntity.ok(userReg.toString());
    }
}
