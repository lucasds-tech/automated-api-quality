package suport.hooks;

import com.lstech.api_test_automation.api.common.util.RestAssuredConfig;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        RestAssuredConfig.init();
    }

}
