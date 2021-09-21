package com.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

/*
    FileFilter
*/
public class Test {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\Administrator\\Desktop\\a");
        // FilenameFilter ff = new FilenameFilter() {
        //     @Override
        //     public boolean accept(File dir, String name) {
        //         return name.endsWith(".txt");
        //     }
        // };
        // String[] list = f.list(ff);
        // String[] list = f.list((File dir, String name)->{ return name.endsWith(".txt");});
        String[] list = f.list((dir, name) -> name.endsWith(".txt"));
        System.out.println(Arrays.toString(list));
    }
}
