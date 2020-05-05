package com.endava.endgame.WebDriverSingleton;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class SetProperties {
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

            // save properties to project root folder
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
