package com.william.finance.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity /*Indica que a classe será uma tabela no BD*/
@Table(name = "tb_users")/*user no BD é uma palavra reservada, ou seja, quando tentou criar uma tabela com o nome user deu erro*/
@Data /*Cria automaticamente getters, setters, toString, equals(Para comparar a igualdade entre dois objetos) e hashcode(Gera uma referencia em numeros inteiros que facilita na hora de armazenar em coleções)*/
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Column(unique = true)
    private Long cpf;

    @Past
    private LocalDate birthDate;/*LocalDate é mais atualizada do que Date*/

    @OneToMany(mappedBy = "user")/*Tem que colocar onde está referenciado na outra classe*/
    private List<Spends> spends;

    @OneToMany(mappedBy = "user")
    private List<Budget> budgets;

    @OneToMany(mappedBy = "user")
    private List<Category> categories;
}
