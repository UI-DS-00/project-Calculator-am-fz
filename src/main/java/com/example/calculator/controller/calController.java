package com.example.calculator.controller;

import com.example.calculator.service.Services;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class calController {

    Services services;
    @PostMapping("/user")
    public ResponseEntity<String> loginUser(@RequestBody String input) {
        return new ResponseEntity<>( services.idk(input), HttpStatus.OK);
    }
}
