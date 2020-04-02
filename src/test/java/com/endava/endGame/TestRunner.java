package com.endava.endgame;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.endava.endGame.steps",
        tags = {"@Alina", "@Anna", "@Andrei", "@Vlad"},
        plugin = {"pretty"})

public class TestRunner {
}