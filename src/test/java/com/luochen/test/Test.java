package com.luochen.test;

import java.io.File;

/**
 * @author luochen
 */
public class Test {

    private int count;

    @org.junit.Test
    public void test(){
        File file = new File("");
        countFiles(new File(file.getAbsolutePath()+"/src/main"));
        System.out.println(count);
    }
    public void countFiles(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()){
                    countFiles(file1);
                }else {
                    if (file1.getName().endsWith(".java")){
                        System.out.println(file1.getName());
                        count++;
                    }
                }
            }
        }
    }
}
