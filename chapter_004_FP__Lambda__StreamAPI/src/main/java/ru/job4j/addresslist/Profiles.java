package ru.job4j.addresslist;

import java.util.List;
import java.util.stream.Collectors;

//В туристической компании появилась задача составить список адресов клиентов.
//В анкете у клиента, есть адрес проживания.
//1. Создать класс Profiles и метод List<Address> collect(List<Profile> profiles);
//2. При решении задания нужно использовать Stream API, метод map, метод collect(Collections.toList());
//3. Метод Stream.map - принимает элемент потока и возвращает другой элемент.

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
        return result;
    }
}
