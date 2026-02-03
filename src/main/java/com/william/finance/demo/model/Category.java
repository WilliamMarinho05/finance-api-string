package com.william.finance.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_Categories")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    private String name;

    @ManyToMany(mappedBy =  "categories")
    private List<Spends> spends;
    /*Usa o mappedBy quando a classe dominante já fez a ligação com o ManyToMany*/
    @ManyToMany(mappedBy = "categories")
    private List<Budget> budgets;

    @PositiveOrZero
    private BigDecimal amount;
}
