package web.test;

import org.junit.jupiter.api.Test;
import web.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BaseTest {

    @Test
    void successLoginWithEmailAndPassTest() {
        new LoginPage()
                .setLogin("max.mustermann@storemind.de")
                .setPass("MMStore*Mind")
                .clickEnter();
        $("body").shouldHave(text("Geben Sie bitte die Store ID ein."));

    }

    @Test
    void successLoginToStoreTest() {
        new LoginPage()
                .setLogin("max.mustermann@storemind.de")
                .setPass("MMStore*Mind")
                .clickEnter()
                .setStoreId("0256")
                .clickSearchStore()
                .clickEnterToStore();
        $("body").shouldHave(text("Cockpit"));

    }
}
