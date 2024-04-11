package web.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import web.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static web.data.TestData.*;

public class LoginTest extends BaseTest {

    @Test
    @Tags({@Tag("login"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Login to App with Email and Password")
    void successLoginWithEmailAndPassTest() {
        new LoginPage()
                .setEmail(testData.MAIL)
                .setPass(testData.PASS)
                .clickEnter();
        $("body").shouldHave(text("Geben Sie bitte die Store ID ein."));

    }

    @Test
    @Tags({@Tag("login"), @Tag("smoke"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Login to Store")
    void successLoginToStoreTest() {
        new LoginPage()
                .setEmail(testData.MAIL)
                .setPass(testData.PASS)
                .clickEnter()
                .setStoreId(testData.STORE_ID)
                .clickSearchStore()
                .clickEnterToStore();
        $("body").shouldHave(text("Cockpit"));

    }

    @Test
    @Tags({@Tag("login"), @Tag("smoke"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Check Find another store button")
    void changeAnotherStoreTest() {
        new LoginPage()
                .setEmail(testData.MAIL)
                .setPass(testData.PASS)
                .clickEnter()
                .setStoreId(testData.STORE_ID)
                .clickSearchStore()
                .clickToFindAnotherStore();
        $("body").shouldHave(text("Geben Sie bitte die Store ID ein."));

    }

    @Test
    @Tags({@Tag("login"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Login to App with wrong Email and Pass")
    void loginToStoreWithWrongEmailAndPassTest() {
        new LoginPage()
                .setEmail(testData.RANDOM_EMAIL)
                .setPass(testData.RANDOM_PASS)
                .clickEnter();
        $("[aria-invalid='true']").shouldBe(visible);

    }

    @Test
    @Tags({@Tag("login"), @Tag("smoke"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Login with wrong Store Id")
    void wrongStoreIdTest() {
        new LoginPage()
                .setEmail(testData.MAIL)
                .setPass(testData.PASS)
                .clickEnter()
                .setStoreId(INVALID_STORE_ID)
                .clickSearchStore();

        $("[aria-invalid='true']").shouldBe(visible);
        $("body").shouldHave(text("Store ID fehlt"));

    }


}
