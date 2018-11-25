package jdbc;

import exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyDB {

    private static Properties properties;

    private PropertyDB() {
        throw new IllegalStateException("Utility class");
    }

    public static String getProperty(final String ip) {
        return properties.getProperty(ip);
    }

    public static void init() {
        properties = new Properties();
        final InputStream streamConfig = PropertyDB.class.getResourceAsStream("/config.properties");
        if (streamConfig == null) {
            throw new DaoException("No properties!!!");
        }
        try {
            properties.load(streamConfig);
        } catch (final IOException e) {
            throw new DaoException("Configuration could not be loaded!");
        }
    }
}
