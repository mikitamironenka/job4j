package ru.job4j.tdd;

import jdk.jfr.Description;
import lombok.SneakyThrows;
import org.junit.Test;
import ru.job4j.tdd.exception.UnwantedKeyException;
import ru.job4j.tdd.exception.WrongKeyException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Description("Все данные валидные. Ожидаем правильный ответ.")
    @Test
    public void whenOk() {

        String template = "I am a %s, Who are %s?";
        Map<String, String> map = new HashMap<>();
        map.put("John Wick", "you");
        GeneratorImpl generator = new GeneratorImpl();
        String result = generator.produce(template, map);
        assertEquals( "I am a John Wick, Who are you?", result);
    }

    @Description("В шаблоне есть ключи, которых нет в карте." +
        "Ожидаем исключение WrongKeyException")
    @Test(expected = WrongKeyException.class)
    public void whenWrongKeys() {
        String template = "I am a %s, Who are %s?";
        Map<String, String> map = new TreeMap<>();
        map.put("John Bohn", "me");
        GeneratorImpl generator = new GeneratorImpl();
        generator.produce(template, map);
    }

    @Description("В карте есть лишние ключи. " +
        "Ожидаем исключение UnwantedKeyException")
    @Test(expected = UnwantedKeyException.class)
    public void whenUnwantedKeys() {
        String template = "I am a %s, Who are %s? ";
        Map<String, String> map = new TreeMap<>();
        map.put("John Bohn", "you");
        map.put("John Grrr", "you");
        GeneratorImpl generator = new GeneratorImpl();
        generator.produce(template, map);
    }
}