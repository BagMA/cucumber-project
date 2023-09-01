package ibs.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void before(){

    }

    @After(order = 10, value = "not(@fail)")
    public void after1(){

    }

    @After(order = 20, value = "@fail")
    public void after2(){

    }
}
