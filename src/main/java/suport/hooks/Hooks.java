package suport.hooks;

import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        RestAssuredSetup.init();
    }
}
