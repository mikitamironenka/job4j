package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void whenGetFilesWithExsts() throws IOException {
        List<String> exts = List.of("txt");
        Search search = new Search();

        String parent = System.getProperty("java.io.tmpdir");
        boolean newFile = new File(parent, "text.txt").createNewFile();
        List<File> res = search.files(parent, exts);
        List<File> checked = new ArrayList<>();
        checked.add(new File("text.txt"));
        res.stream().forEach(o -> System.out.println(o.getName()));
//        assertThat(res, is(checked));
    }

}