package ru.job4j.studentfromlisttomap;

//1. Создать список учеников. Класс Student взять из задания "Фильтрация учеников"
//2. Преобразовать список учеников в Map.
//3. В качестве ключа использовать фамилию ученика.
//4. В качестве значения использовать объект ученика.

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {

    public Map<String, Student> convertListToMap(List<Student> list) {
        final Map<String, Student> collect = list
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e,
                        (a1, a2) -> a1
                ));
        return
                collect;
    }

}
