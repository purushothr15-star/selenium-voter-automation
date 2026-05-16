
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {

        try {

            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("globalProps.properties");

            if (input == null) {
                throw new RuntimeException("globalProps.properties not found");
            }
            prop = new Properties();

            prop.load(input);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String get(String key) {

        return prop.getProperty(key);
    }
}