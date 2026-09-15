package suport.hooks;

import com.lstech.api_test_automation.api.utils.RestAssuredConfig;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        RestAssuredConfig.init();
    }
}
