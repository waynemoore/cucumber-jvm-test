package xbridge;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class HookSteps {

    @Autowired
    private ATM atm;

    @Order(1)
    @Before
    public void before() {
        System.out.println("Before");
    }

    @Order(1)
    @After
    public void after() {
        System.out.println("After");
    }

    @Order(2)
    @Before({"@afm"})
    public void beforeAFM() {
        System.out.println("Before afm");
    }

    @Order(2)
    @After({"@afm"})
    public void afterAFM() {
        System.out.println("After afm");
    }
}