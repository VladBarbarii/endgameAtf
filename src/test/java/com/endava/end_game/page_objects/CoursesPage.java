package com.endava.end_game.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class CoursesPage {

    public CoursesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"addItemBtn\"]/i")
    private WebElement addButton;
    @FindBy(linkText = ".dataRaw>:nth-child(2)")
    private List<WebElement> coursesNames;
    @FindBy(linkText = ".dataRaw>:nth-child(5)")
    private List<WebElement> companyNames;
    @FindBy(xpath = "//a[contains(text(),'Company')]")
    private WebElement company;
    @FindBy(xpath = "//a[contains(text(),'Title')]")
    private WebElement title;

    public WebElement getTitle() {
        return title;
    }

    public WebElement getCompany() {
        return company;
    }

    public List<WebElement> getCompanyNames() {
        return companyNames;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public List<WebElement> getCoursesNames() {
        return coursesNames;
    }
}