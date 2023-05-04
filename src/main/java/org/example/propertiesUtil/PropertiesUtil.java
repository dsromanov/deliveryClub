package org.example.propertiesUtil;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    private PropertiesUtil() {
    }

    static {
        try {
            loadProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() throws IOException {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("database.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}