package ru.job4j.io.archiveproject;

import java.util.HashMap;
import java.util.Map;

public class Args {

    private final String[] args;
    private Map<String, String> arguments;

    public Args(String[] args) {
       this.args = args;
       this.arguments = validate(args);
    }

    public Map<String, String> getArguments() {
        return this.arguments;
    }

    public String directory() {
        return this.arguments.get("-d");
    }

    public String exclude() {
        String ext = this.arguments.get("-e");
        return ext.substring(ext.indexOf(".") + 1);
    }

    public String output() {
        return this.arguments.get("-o");
    }

    public Map<String, String> validate(String[] ar) {
        Map<String, String> result = new HashMap<>();
        for (int i = 1; i < ar.length; i = i + 2) {
            int k = i;
            result.put(ar[k - 1], ar[i]);
        }
        return result;
    }
}
