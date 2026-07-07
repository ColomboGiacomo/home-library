package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * Classe per il recupero delle informazioni per la connessione al db
 */

public class ResourcesAccessUtils {
	
    public static Properties loadProperties(String propertiesPath) throws IOException {

        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(propertiesPath)) {
            properties.load(input);
        }

        return properties;
    }
}
