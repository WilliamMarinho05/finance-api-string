package com.william.finance.demo.controller;

import com.william.finance.demo.model.Budget;
import com.william.finance.demo.repository.BudgetRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/budgets")
@RequiredArgsConstructor

public class BudgetController {
    private final BudgetRepository budgetRepository;

    @GetMapping
    public List<Budget> listAll(){
        return budgetRepository.findAll();
    }

    @PostMapping
    public Budget create(@Valid @RequestBody Budget budget){
        return budgetRepository.save(budget);
    }
}
