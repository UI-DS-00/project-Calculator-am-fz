package com.example.calculator.repository;

import com.example.calculator.models.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Integer> {

}
