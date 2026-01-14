package com.example.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            String path = "src/main/resources/config.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String getProperty(String key) {
        if (System.getProperty(key) != null) {
            return System.getProperty(key);
        }
        return properties.getProperty(key);
    }

    public static boolean getBooleanProperty(String key) {
        if (System.getProperty(key) != null) {
            return Boolean.parseBoolean(System.getProperty(key));
        }
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}
