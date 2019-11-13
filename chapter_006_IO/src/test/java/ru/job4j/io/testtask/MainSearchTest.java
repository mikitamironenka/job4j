package ru.job4j.io.testtask;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MainSearchTest {

    private static String source;
    private static String out;
    private static File sourceFile;
    private static File outPut;
    private static String sourcePath;
    private static String outPutPath;

    @BeforeClass
    public static void init() {
        source = "src/test/java/ru/job4j/io/tmpdir";
        out = "src/test/java/ru/job4j/io/tmpdir/log.txt";
        sourceFile = new File(source);
        outPut = new File(out);
        sourcePath = sourceFile.getAbsolutePath();
        outPutPath = outPut.getAbsolutePath();
    }

    @Test
    public void whenSearchWithFileName() {
        String[] arguments = new String[]{"-d", sourcePath, "-n", "file.txt", "-f", "-o", outPutPath};
        List<String> result = new MainSearch(new Args(arguments)).init();
        assertThat(result.get(0), is("file.txt"));
    }

    @Test
    public void whenSearchWithFileMask() {
        String[] arguments = new String[]{"-d", sourcePath, "-n", "*.txt", "-m", "-o", outPutPath};
        List<String> result = new MainSearch(new Args(arguments)).init();
        assertThat(result.get(1), is("filetwo.txt"));
    }
}