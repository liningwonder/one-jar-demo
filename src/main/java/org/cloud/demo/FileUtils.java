package org.cloud.demo;


import java.io.File;

public final class FileUtils {
    public static boolean isFile(String fileName) {
        return new File(fileName).isFile();
    }
}
