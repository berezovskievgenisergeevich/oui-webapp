package web.test;

import com.codeborne.selenide.Configuration;
import config.TestsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import web.data.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    public TestData testData = new TestData();

    @BeforeAll
    static void setUp() {
        TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());

        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
        Configuration.browser = config.browser();
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }


}
