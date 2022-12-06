package org.TestVagrantTechnologies.utils.propertieloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {
    /**
     * The constant APPCONFIG.
     */
    public static ApplicationConfig APPCONFIG = new ApplicationConfig();
    private final Properties appConfig = new Properties();
    private final static Logger Log = LoggerFactory.getLogger(ApplicationConfig.class);

    /**
     * Instantiates a new Application config.
     */
    public ApplicationConfig() {
        try {
            String propFileName = "properties/application.properties";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                appConfig.load(inputStream);
            }
        } catch (Exception e) {
            Log.info(e.getMessage());
        }
    }

    /**
     * Gets property.
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(String key) {
        return appConfig.getProperty(key);
    }

}
