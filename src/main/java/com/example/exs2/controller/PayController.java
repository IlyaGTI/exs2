package com.example.exs2.controller;

import com.example.exs2.entity.Payment;
import com.example.exs2.entity.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @PostMapping("/pay")
    public ResponseEntity<Object> pay(@RequestBody Payment payment, Result result) {
        if(payment.getPart() == 'к') {
            payment.setState(true);
            result.setPercent((payment.getValue()/100)*15);
            result.setBalance(payment.getValue() - result.getPercent());
        } else if (payment.getPart() == 'п') {
            payment.setState(false);
            result.setPercent(0);
            result.setBalance(payment.getValue());
        } else {
            return ResponseEntity.badRequest().body(payment);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
