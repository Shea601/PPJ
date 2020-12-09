package edu.cdu.ppj.chapter8.three;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ListFile {
    public void listJavaFile(String fileName) {
        File file = new File(fileName);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                String name = files[i].getName();
                if (name.trim().toLowerCase().endsWith(".java")) {
                    System.out.println(name + "\t");
                }
                if (files[i].isDirectory()) {
                    String path = files[i].getPath();
                    listJavaFile(path);
                }
            }
        }
    }

    @Test
    public void testListJavaFile() throws Exception {
        listJavaFile(".");
    }
}