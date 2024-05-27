package com.ecommerce.utilities;

import java.util.Properties;

// Singleton Design Pattern
// We ensure that a single object of this class is created
// The config.properties file will be loaded only once

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyUtilities.propertyLoader("src/main/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseURL");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property baseURL is not specified in the config.properties file");
        }
    }

    public String getEmail() {
        String prop = properties.getProperty("email");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property email is not specified in the config.properties file");
        }
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property password is not specified in the config.properties file");
        }
    }
}
