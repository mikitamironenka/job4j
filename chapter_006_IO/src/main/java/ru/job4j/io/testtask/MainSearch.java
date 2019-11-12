package ru.job4j.io.testtask;

import java.io.File;
import java.util.List;

public class MainSearch {

    private FileSearcher fileSearcher;
    private FileSaver fileSaver;
    private Args args;

    public MainSearch(Args args) {
        this.args = args;
        this.fileSearcher = new FileSearcher(args);
        this.fileSaver = new FileSaver();
    }

    public List<String> init() {
        return this.fileSaver.saveFilesToDirectory(this.fileSearcher.search(), this.args.output());
    }

}
