package com.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileWriteUtil {

    public static void writeFile(Properties properties) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/config/Properties");
        properties.store(fileOutputStream, "");
    }
}
