package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class BradfordFactorPage {
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div[1]/h4/a[3]")
    private WebElement pdfIcon;
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div[1]/h4/a[2]")
    private WebElement csvIcon;

    public BradfordFactorPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getCsvIcon() {
        return csvIcon;
    }

    public WebElement getPdfIcon() {
        return pdfIcon;
    }
}
