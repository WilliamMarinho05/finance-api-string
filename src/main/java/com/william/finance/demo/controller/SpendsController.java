package com.william.finance.demo.controller;

import com.william.finance.demo.model.Spends;
import com.william.finance.demo.repository.SpendsRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/spends")
@RequiredArgsConstructor

public class SpendsController {
    private final SpendsRepository spendsRepository;

    @GetMapping
    public List<Spends> listAll(){
        return spendsRepository.findAll();
    }

    @PostMapping
    public Spends create(@Valid @RequestBody Spends spends){
        return spendsRepository.save(spends);
    }
}
