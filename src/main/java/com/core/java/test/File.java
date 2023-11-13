package com.core.java.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class File {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("D:\\test1.txt"));
        for (String line: lines) {
            char[] charArray = line.toCharArray();
            for (int i = 0;  i<charArray.length; i++) {
                System.out.println("index "+i);
                System.out.println("character "+charArray[i]);
            }

        }
    }
}
