package ru.job4j.io.testtask;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MainSearchTest {


    @Test
    public void whenSearchWithFileName() {
        String source = "src/test/java/ru/job4j/io/tmpdir";
        String out = "src/test/java/ru/job4j/io/tmpdir/log.txt";
        File sourceFile = new File(source);
        File outPut = new File(out);
        String sourcePath = sourceFile.getAbsolutePath();
        String outPutPath = outPut.getAbsolutePath();
        String[] arguments = new String[]{"-d", sourcePath, "-n", "file.txt", "-f", "-o", outPutPath};
        List<String> result = new MainSearch(new Args(arguments)).init();
        assertThat(result.get(0), is("file.txt"));
    }

    @Test
    public void whenSearchWithFileMask() {
        String source = "src/test/java/ru/job4j/io/tmpdir";
        String out = "src/test/java/ru/job4j/io/log.txt";
        File sourceFile = new File(source);
        File outPut = new File(out);
        String sourcePath = sourceFile.getAbsolutePath();
        String outPutPath = outPut.getAbsolutePath();
        String[] arguments = new String[]{"-d", sourcePath, "-n", "*.txt", "-m", "-o", outPutPath};
        List<String> result = new MainSearch(new Args(arguments)).init();
        assertThat(result.get(1), is("filetwo.txt"));
    }
}