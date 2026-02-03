package com.william.finance.demo.controller;

import com.william.finance.demo.model.User;
import com.william.finance.demo.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController/*Transforma um objeto java em json antes de mandar para a internet*/
@RequestMapping("/users")/*Define que o começo dos links relacionados começam com /users*/
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;/*Tem 'final' para que o 'requiredArgs...' reconheça e faça um construtor com esse campo com argumento*/

    @GetMapping/*Vai retornar todos os usuarios que existem no BD*/
    public List<User> listAll(){
        return userRepository.findAll();
    }

    @PostMapping/*Vai ser usado para inserir no BD*/
    public User create(@Valid @RequestBody User user){/*@valid vai verificar se todos os dados estão no formatos adequados de acordo com as validações e o @requestbody vai pegar o que veio da internet, em json, e transformar emm um objeto java*/
        return userRepository.save(user);
    }
}
