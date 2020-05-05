package com.endava.endgame;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<ScenarioKeys, Object> data;

    private static ScenarioContext instance;

    private ScenarioContext() {
        this.data = new HashMap<>();
    }

    public static ScenarioContext getInstance() {

        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void saveData(ScenarioKeys key, Object value) {
        data.put(key, value);
    }

    public Object getData(ScenarioKeys key) {
        return data.get(key);
    }

    public void resetContext(ScenarioContext scenarioContext) {
        scenarioContext.data.clear();
    }
}