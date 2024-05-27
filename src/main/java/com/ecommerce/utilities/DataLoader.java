package com.ecommerce.utilities;

import java.util.Properties;

// Singleton Design Pattern
// We ensure that a single object of this class is created
// The data.properties file will be loaded only once

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader() {
        properties = PropertyUtilities.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getProductId() {
        String prop = properties.getProperty("product_id");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property product_id is not specified in the data.properties file");
        }
    }

    public String getProductName() {
        String prop = properties.getProperty("product_name");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property product_name is not specified in the data.properties file");
        }
    }
}
