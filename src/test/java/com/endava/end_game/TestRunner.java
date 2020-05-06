package com.endava.end_game;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.endava.endgame.steps",
        tags = {"@Alina", "@Anna", "@Andrei", "@Vlad"},
        plugin = {"pretty"},
        stepNotifications = true)
public class TestRunner {
}