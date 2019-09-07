package ru.job4j.addressbook;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    private PhoneDictionary phones;

    @Before
    public void init() {
        phones = new PhoneDictionary();
        var name = "Petr";
        var surname = "Arsentev";
        var phone = "534872";
        var city = "Bryansk";
        phones.add(
                new Person(name, surname, phone, city)
        );
    }

    @Test
    public void whenFindByName() {
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySurname() {
        List<Person> persons = phones.find("Arsentev");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhone() {
        List<Person> persons = phones.find("534872");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByAddress() {
        List<Person> persons = phones.find("Bryansk");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySuffix() {
        List<Person> persons = phones.find("nsk");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}