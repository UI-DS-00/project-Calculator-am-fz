package com.example.calculator.controller;

import com.example.calculator.models.History;
import com.example.calculator.service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor
@RestController
public class HistoryController {

    private HistoryService historyService;

    @GetMapping("/showHistory")
    public ResponseEntity<List<History>> showHistory() throws Throwable {
        return new ResponseEntity<>( historyService.returnAll(), HttpStatus.OK);
    }
    @GetMapping("/deleteHistory")
    public ResponseEntity<String> deleteHistory() throws Throwable {
        return new ResponseEntity<>( historyService.deleteHistory(), HttpStatus.OK);
    }
}
