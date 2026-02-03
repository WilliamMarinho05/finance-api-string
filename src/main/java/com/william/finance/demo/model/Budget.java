package com.william.finance.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_budgets")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @PositiveOrZero
    private BigDecimal amount;

    @Positive
    @NotNull
    private BigDecimal limitValue;

    @NotNull
    private LocalDate startDate;

    @NotNull
    @Future
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "categories_budgets",
            joinColumns = @JoinColumn(name = "budget_id"),/*Sempre se refere a classe onde esta*/
            inverseJoinColumns = @JoinColumn(name = "category_id")/*Sempre se refere a outra classe referenciada*/
    )
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
