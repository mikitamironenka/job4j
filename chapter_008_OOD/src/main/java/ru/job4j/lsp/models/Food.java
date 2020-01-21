package ru.job4j.lsp.models;

//Часть 1.
//Создать класс Food с полями. Name, expaireDate, createDate, price, disscount.
// На основе класса Food создать другие продукты.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Food {

    private String name;
    private LocalDate createDate;
    private LocalDate expirationDate;
    private double price;
    private double discount;
}
