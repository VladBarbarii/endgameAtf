package com.endava.end_game;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.endava.end_game.steps",
        tags = {/*"@Alina", "@Anna", "@Vlad",*/ "@Andrei"},
        plugin = {"pretty"},
        stepNotifications = true)
public class TestRunner {
}