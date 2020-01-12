package ru.job4j.lsp.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meet extends Food {

    private String name;
    private LocalDate createDate;
    private LocalDate expirationDate;
    private double price;
    private double discount;
}
