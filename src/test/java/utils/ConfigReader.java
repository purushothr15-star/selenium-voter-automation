package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    static {

        try

    {
        FileInputStream fis = new FileInputStream("C:\\Users\\aishw\\Purushoth projects\\Selenium Java Basics\\src\\test\\resources\\globalProps.properties");
        prop = new Properties();
        prop.load(fis);
    } catch(
    IOException e)

    {
        e.printStackTrace();
    }
    }

    public static String get(String key){
        return prop.getProperty(key);
    }
    }
