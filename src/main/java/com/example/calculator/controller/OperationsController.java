package com.example.calculator.controller;

import com.example.calculator.service.Services;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class OperationsController {

    private Services services;
    @PostMapping("/calculator")
    public ResponseEntity<String> calculator(@RequestBody String input) throws Throwable {
        return new ResponseEntity<>( services.calculate(input), HttpStatus.OK);
    }

    @PostMapping("/sin")
    public ResponseEntity<String> sin(@RequestBody String input) throws Throwable {
        return new ResponseEntity<>( services.sinCalculator(input), HttpStatus.OK);
    }
    @PostMapping("/cos")
    public ResponseEntity<String> cos(@RequestBody String input) throws Throwable {
        return new ResponseEntity<>( services.cosCalculator(input), HttpStatus.OK);
    }
    @PostMapping("/tan")
    public ResponseEntity<String> tan(@RequestBody String input) throws Throwable {
        return new ResponseEntity<>( services.tanCalculator(input), HttpStatus.OK);
    }

}
