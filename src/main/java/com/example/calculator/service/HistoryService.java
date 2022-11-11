package com.example.calculator.service;

import com.example.calculator.models.History;
import com.example.calculator.repository.HistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class HistoryService {

    private HistoryRepository hs;

    public void addToDB(String input,String answer){
        History history= new History();
        history.setCalculation(input);
        history.setAnswer(answer);
        hs.save(history);

    }


    public List<History> returnAll(){
        List<History> histories = hs.findAll();

        return histories;
    }

    public String deleteHistory(){
        hs.deleteAll();

        return "Finished";
    }

}
