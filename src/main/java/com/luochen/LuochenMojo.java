package com.luochen;

import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.List;

/**
 * @author luochen
 */
@Mojo(name = "luochen")
public class LuochenMojo extends AbstractMojo {
    private int count;
    @Parameter(property = "msg")
    private String msg;
    @Parameter
    private String dir;
    @Parameter
    private List<String> params;

    public void execute() throws MojoExecutionException, MojoFailureException {
        if (StringUtils.isNotBlank(dir)) {
            countFiles(new File(dir));
        }
        System.out.println(dir + " has " + count + " java files.");
        System.out.println(msg);
        System.out.println(params);
    }

    public void countFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    countFiles(file1);
                } else {
                    if (file1.getName().endsWith(".java")) {
                        System.out.println(file1.getName());
                        count++;
                    }
                }
            }
        }
    }


}
