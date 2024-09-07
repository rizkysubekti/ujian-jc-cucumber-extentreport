package com.juaracoding.utils;

public enum ScenarioTest {

    T1("Successful login"),
    T2("Unsuccessful login with invalid username"),
    T3("Unsuccessful login with invalid password"),
    T4("Unsuccessful login with invalid username"),
    T5("Successfully add 2 products to cart"),
    T6("Successfully complete checkout"),
    T7("Unsuccessful checkout due to missing postal code");

    private String scenarioTestName;

    ScenarioTest(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName() {
        return scenarioTestName;
    }
}
