package ru.job4j.lsp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Beer extends Food {

    private String name;
    private LocalDate createDate;
    private LocalDate expirationDate;
    private double price;
    private double discount;
}
