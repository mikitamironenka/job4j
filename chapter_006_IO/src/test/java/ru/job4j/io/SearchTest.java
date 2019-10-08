package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void whenGetFilesWithExsts() {
        List<String> exts = List.of("txt", "xml");
        Search search = new Search();
        String parent = System.getProperty("java.ru.job4j.io.tmpdir");
        String parPath = new File(parent).getAbsolutePath();
        System.out.println(parPath);
        List<File> res = search.files(parPath, exts);
        res.forEach(System.out :: println);
    }

}