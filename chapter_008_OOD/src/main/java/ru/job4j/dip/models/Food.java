package ru.job4j.dip.models;

//Часть 1.
//Создать класс Food с полями. Name, expaireDate, createDate, price, disscount.
// На основе класса Food создать другие продукты.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
