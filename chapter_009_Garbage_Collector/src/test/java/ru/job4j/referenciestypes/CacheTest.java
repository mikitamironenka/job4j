package ru.job4j.referenciestypes;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class CacheTest {

    private static final String lineSeparator = System.getProperty("line.separator");

    @Test
    public void whenCacheGetName() throws IOException {
        File namesFile = new File(System.getProperty("java.io.tmpdir"), "Names.txt");
        File addressesFile = new File(System.getProperty("java.io.tmpdir"), "Address.txt");
        namesFile.createNewFile();
        addressesFile.createNewFile();
        String names = String.format("Alex%sDraco%sBoris%s", lineSeparator, lineSeparator, lineSeparator);
        String address = String.format("Gdansk%sMoscow%sAshhabad%s", lineSeparator, lineSeparator, lineSeparator);
        try (FileWriter namesWriter = new FileWriter(namesFile);
             FileWriter addressWriter = new FileWriter(addressesFile)) {
            namesWriter.write(names);
            addressWriter.write(address);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Cache softReferenceCache = new Cache(System.getProperty("java.io.tmpdir"));
        assertTrue(softReferenceCache.getFileContent(namesFile.getName()).equals(names));
        assertTrue(softReferenceCache.getFileContent(addressesFile.getName()).equals(address));
        namesFile.delete();
        addressesFile.delete();
    }

    @Test (expected = NullPointerException.class)
    public void whenFileNotExist() {
        File filePhones = new File(System.getProperty("java.io.tmpdir"), "Countries.txt");
        Cache softReferenceCache = new Cache(System.getProperty("java.io.tmpdir"));
        softReferenceCache.getFileContent(filePhones.getName());
    }

}