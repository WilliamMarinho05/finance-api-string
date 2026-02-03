package com.william.finance.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_spends")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Spends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;/*Consegue armazenar mais ids, muito mais*/


    @ManyToOne
    @JoinColumn(name = "user_cpf")/*Nome da chave estrangeira dessa tabela será 'user_CPF'*/
    private User user;

    @Positive
    @NotNull
    private BigDecimal value;/*BigDecimal é o indicado quando for para sistemas 'financeiros' pois tem calculos decimais mais precisos do que double e float*/

    @NotNull
    @PastOrPresent
    private LocalDate date;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "spends_category",
            joinColumns =  @JoinColumn(name = "spend_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

}
