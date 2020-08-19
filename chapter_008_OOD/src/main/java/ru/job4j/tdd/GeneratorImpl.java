package ru.job4j.tdd;

import lombok.SneakyThrows;
import ru.job4j.tdd.exception.UnwantedKeyException;
import ru.job4j.tdd.exception.WrongKeyException;
import java.util.Iterator;
import java.util.Map;

public class GeneratorImpl implements Generator {
    @SneakyThrows
    @Override
    public String produce(String template, Map<String, String> map) {
        Iterator iterator = map.entrySet().iterator();
        Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
        if (iterator.hasNext()) {
            throw new UnwantedKeyException("В карте лишние ключи.");
        }
        if (!entry.getValue().equals("you")) {
            throw new WrongKeyException("Неправильный ключ в карте.");
        }
        String name = entry.getKey();
        String subject = entry.getValue();
        return String.format(template, name, subject);
    }
}
