package ru.job4j.io.archiveproject;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//        1. Задана директория проекта, например: c:\project\job4j\
//        2. В качестве ключа передается  расширения файлов, которые не нужно включать в архив.
//        3. Архив должен сохранять структуру проекта.
//        4. Запуск проекта java -jar pack.jar -d c:\project\job4j\ -e *.java -o project.zip
//        java -jar pack.jar - Это собранный jar.
//        -d - directory - которую мы хотим архивировать
//        -e - exclude - исключить файлы *.xml
//        -o - output - во что мы архивируем.
//        У вас должен быть класс new Args(agrs)
//        с методами directory() exclude() output();
//        5. Для архивации использовать классы ZipOutputStream.java.

public class Zip {

    /**
     * A constants for buffer size used to read/write data
     */
    private static final int BUFFER_SIZE = 4096;

    private Args args;
    private String source;
    private String target;
    private String exclude;

    public Zip(String[] args) {
        this.args = new Args(args);
        initParameters();
    }

    private void initParameters() {
        this.source = this.args.directory();
        this.target = this.args.output();
        this.exclude = this.args.exclude();
    }

    /**
     * Compresses a list of files to a destination zip file
     */
    public void zip() {
        List<File> listFiles = Arrays.asList(new File(this.source).listFiles());
        String fileExt;
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(this.target)) ) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    zipDirectory(file, file.getName(), zos);
                } else {
                    String curr = file.getName();
                    if (curr.contains(".")) {
                        fileExt = curr.substring(curr.indexOf(".") + 1);
                        if (!fileExt.equals(this.exclude)) {
                            zipFile(file, zos);
                        }
                    }
                }
            }
            zos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a directory to the current zip output stream
     * @param folder the directory to be  added
     * @param parentFolder the path of parent directory
     * @param zos the current zip output stream
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void zipDirectory(File folder, String parentFolder, ZipOutputStream zos) throws FileNotFoundException, IOException {

        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                zipDirectory(file, parentFolder + "/" + file.getName(), zos);
                continue;
            }
            zos.putNextEntry(new ZipEntry(parentFolder + "/" + file.getName()));
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            long bytesRead = 0;
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read = 0;
            while ((read = bis.read(bytesIn)) != -1) {
                zos.write(bytesIn, 0, read);
                bytesRead += read;
            }
            zos.closeEntry();
        }
    }
    /**
     * Adds a file to the current zip output stream
     * @param file the file to be added
     * @param zos the current zip output stream
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void zipFile(File file, ZipOutputStream zos) throws FileNotFoundException, IOException {
        zos.putNextEntry(new ZipEntry(file.getName()));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        long bytesRead = 0;
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = bis.read(bytesIn)) != -1) {
            zos.write(bytesIn, 0, read);
            bytesRead += read;
        }
        zos.closeEntry();
    }
}
