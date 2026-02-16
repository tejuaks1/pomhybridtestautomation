package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private ConfigFileReader instance;
    private Properties properties;

    private ConfigFileReader() throws IOException {
        properties = System.getProperties();
        properties.load(new FileInputStream("src/test/resources/config/config.properties"));
    }


    public ConfigFileReader getInstance() throws IOException {
        if (instance == null)
            instance = new ConfigFileReader();
        return instance;
    }


    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getLoginUrl() {
        return properties.getProperty("login.url", getBaseUrl() + "/login");  // fallback
    }
}
