package ru.job4j.tracker.input;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        List<Integer> list =  new ArrayList<>();
        list.add(1);
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", list);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, enter validate data again.%n")
                )
        );
    }

    @Test
    public void whenOutOfRangeInput() {
        List<Integer> list =  new ArrayList<>();
        list.add(1);
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"9", "1"})
        );
        input.ask("Enter", list);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please, select key from menu.%n")
                )
        );
    }
}