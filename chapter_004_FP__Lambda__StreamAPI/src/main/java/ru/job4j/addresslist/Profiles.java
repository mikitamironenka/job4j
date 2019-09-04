package ru.job4j.addresslist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//В туристической компании появилась задача составить список адресов клиентов.
//В анкете у клиента, есть адрес проживания.
//1. Создать класс Profiles и метод List<Address> collect(List<Profile> profiles);
//2. При решении задания нужно использовать Stream API, метод map, метод collect(Collections.toList());
//3. Метод Stream.map - принимает элемент потока и возвращает другой элемент.
//1. Доработайте задание "Список Адресов", чтобы список элементов был уникальный. А так же порядок элементов был отсортирован по полю String city.
//2. Для этого чтобы обеспечить уникальность элементов нужно использовать метод Stream().distinct();
//3. Для сортировки нужно использовать метод sorted(Comparator<Address>()).

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
        return result;
    }

    public List<Address> collectUniqueAddresses(List<Profile> profiles) {
        List<Address> result = profiles
                //get stream
                .stream()
                //get stream with addresses
                .map(Profile::getAddress)
                //get distinct elements
                .distinct()
                //sorted them in city field
                .sorted(Comparator.comparing(Address::getCity))
                //collect it to list
                .collect(Collectors.toList());
        return result;
    }
}
