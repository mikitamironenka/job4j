package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void whenGetFilesWithExsts() throws IOException {
        List<String> exts = List.of("txt");
        Search search = new Search();
        String path = "src/test/java/ru/job4j/io/tmpdir";
        File file = new File(path);
        String sourcePath = file.getAbsolutePath();

        List<File> res = search.files(sourcePath, exts);
        assertThat(res.get(0).getName(), is("file.txt"));
        assertThat(res.get(1).getName(), is("log.txt"));
        assertThat(res.size(), is(3));
    }

}