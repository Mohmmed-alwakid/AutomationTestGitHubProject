package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigReader {
    private static final Properties properties = new Properties();
    private static final Logger logger = Logger.getLogger(ConfigReader.class.getName());

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                logger.severe("Unable to find config.properties");
            } else {
                properties.load(input);
                logger.info("Successfully loaded config.properties");
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading config.properties", e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.warning("Property not found: " + key);
        }
        return value;
    }
}