package ibs.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static ibs.steps.MySteps.driver;

public class Hooks {


    @Before
    public void before(){

    }

    @After()
    public void after1(){
        driver.quit();
    }

}
