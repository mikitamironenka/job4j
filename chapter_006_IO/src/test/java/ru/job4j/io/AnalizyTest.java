package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void whenServerUnAvailableThenCreatedPeriods() throws IOException {
        String path = "src/test/resources";
        File file = new File(path);
        String sourcePath = file.getAbsolutePath() + "/source.txt";
        String resultPath = file.getAbsolutePath() + "/unavailable.csv";

        Analizy analizy = new Analizy();
        analizy.unavailable(sourcePath, resultPath);

        List<String> checked = new ArrayList<>();
        checked.add("10:57:01-");
        checked.add("10:59:01" + System.lineSeparator());
        checked.add("11:01:02-");
        checked.add("11:02:02" + System.lineSeparator());
        assertThat(analizy.getList(), is(checked));
    }

}