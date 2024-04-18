package web.test;

import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import web.data.model.Store;
import web.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static web.data.TestData.INVALID_STORE_ID;

@Story("[UI] Login Page Automation")
public class LoginTest extends BaseTest {

    @Test
    @Tags({@Tag("login"), @Tag("regression"), @Tag("ui")})
    @DisplayName("First step authentification with Email and Password")
    void successLoginWithEmailAndPassTest() {
        new LoginPage()
                .setEmail(testData.MAIL)
                .setPass(testData.PASS)
                .clickEnter();
        $("body").shouldHave(text("Geben Sie bitte die Store ID ein."));
    }

    @Test
    @Tags({@Tag("login"), @Tag("smoke"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Login to App with Email, Pass and StoreId")
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
    @DisplayName("Check 'Select another store' button")
    void changeAnotherStoreButtonTest() {
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
    @Disabled("As a demonstration of the demo functionality")
    @Tags({@Tag("login"), @Tag("smoke"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Check 'Select another store' function")
    void selectAnotherStoreTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.setEmail(testData.MAIL)
                .setPass(testData.PASS)
                .clickEnter();
        for (Store store : testData.stores) {
            loginPage.setStoreId(store.getId());
            loginPage.clickSearchStore();

            $("body").shouldHave(text(store.getName()));
            loginPage.clickToFindAnotherStore();
        }

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
    @Disabled("As a demonstration of the demo functionality")
    @Tags({@Tag("login"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Login to App with wrong Email")
    void loginToStoreWithWrongEmailTest() {
        new LoginPage()
                .setEmail(testData.RANDOM_EMAIL)
                .setPass(testData.PASS)
                .clickEnter();
        $("[aria-invalid='true']").shouldBe(visible);
    }

    @Test
    @Tags({@Tag("login"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Login to App with wrong Pass")
    void loginToStoreWithWrongPassTest() {
        new LoginPage()
                .setEmail(testData.MAIL)
                .setPass(testData.RANDOM_PASS)
                .clickEnter();
        $("[aria-invalid='true']").shouldBe(visible);
    }

    @Test
    @Disabled("As a demonstration of the demo functionality")
    @Tags({@Tag("login"), @Tag("smoke"), @Tag("regression"), @Tag("ui")})
    @DisplayName("Login to App with wrong Store Id")
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
