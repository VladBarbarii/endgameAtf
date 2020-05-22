package com.endava.end_game;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.endava.end_game.steps",
        tags = { "@Anna"/*, "@Alina", "@Andrei", "@Vlad"*/},
        plugin = {"pretty","json:target/cucumber.json","html:target/site/cucumber-pretty"},
        stepNotifications = true,
        monochrome = true
)
public class TestRunner {
}