package com.example.calculator.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class Services {
    public String idk(String str){
        System.out.println(str);
        System.out.println("hello");
        return "null";
    }
}
