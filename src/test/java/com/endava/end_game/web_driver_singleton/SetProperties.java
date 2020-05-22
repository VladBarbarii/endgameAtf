package com.endava.end_game.web_driver_singleton;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class SetProperties {
    private static  Logger logger = LogManager.getLogger(SetProperties.class);
    public static void setProperties() {
        try (OutputStream output = new FileOutputStream("src/test/resources/application.properties")) {
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("chrome_path", "src/test/resources/drivers/chromedriver.exe");
            prop.setProperty("firefox_path", "src/test/resources/drivers/geckodriver.exe");
            prop.setProperty("ie_path", "src/test/resources/drivers/IEDriverServer.exe");
            prop.setProperty("chrome_driver", "webdriver.chrome.driver");
            prop.setProperty("firefox_driver", "webdriver.gecko.driver");
            prop.setProperty("ie_driver", "webdriver.ie.driver");
            prop.setProperty("sut_url","https://orangehrm-demo-6x.orangehrmlive.com");
            prop.setProperty("browser","chrome");

            // save properties to project root folder
            prop.store(output, null);
        } catch (IOException io) {
            logger.error("File Not Found");
        }
    }
}
