package com.endava.end_game.page_objects;

import org.openqa.selenium.support.PageFactory;

import static com.endava.end_game.web_driver_singleton.WebDriverSingleton.getDriver;

public class VacanciesPage extends RecruitmentMenuPage {

    public VacanciesPage() {
        PageFactory.initElements(getDriver(), this);
    }

}
