package utils;

import org.openqa.selenium.By;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UiMappingSingleton {
    private static UiMappingSingleton classInstance;

    private static String uiMappingFile = "src/utils/UiMapping.properties";

    private UiMappingSingleton() {
    }

    public static UiMappingSingleton getClassInstance() {
        if (classInstance == null) {
            classInstance = new UiMappingSingleton();
        }
        return classInstance;
    }

    //TODO Maven
    private static String getValueFromFile(String key, String fileName) throws IOException {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new IllegalStateException("Incorrect file path: " + e.getMessage());
        }
        return (p.getProperty(key));
    }


    public By ui(String key) {
        String[] partsOfLocators = new String[2];
        try {
            partsOfLocators = getValueFromFile(key, uiMappingFile).split("\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String findMethod = partsOfLocators[0];
        String locatorValue = partsOfLocators[1];

        // Return By class with appropriate method and locatorValue
        switch (findMethod) {
            case "id":
                return By.id(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            case "css":
                return By.cssSelector(locatorValue);
            case "name":
                return By.name(locatorValue);
            default:
                return By.xpath(locatorValue);
        }
    }
}
