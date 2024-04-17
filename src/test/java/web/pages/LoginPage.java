package web.pages;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginPage {

    public LoginPage() {
        step("Open page: " + Configuration.baseUrl,
                () -> open("/"));
    }

    @Step("Enter email: {email}")
    public LoginPage setEmail(String email) {
        $("[name='email']").val(email);
        return this;
    }

    @Step("Enter pass: {pass}")
    public LoginPage setPass(String pass) {
        $("[name='password']").val(pass);
        return this;
    }

    @Step("click to Autorisieren button")
    public LoginPage clickEnter() {
        $(byText("Autorisieren")).click();
        return this;
    }

    @Step("Enter store Id: {id}")
    public LoginPage setStoreId(String id) {
        $("[name='storeId']").val(id);
        return this;
    }

    @Step("click to Store annehmen button")
    public CockpitPage clickEnterToStore() {
        $(byText("Store annehmen")).click();
        return new CockpitPage();
    }

    @Step("click to Anderen Store suchen button")
    public LoginPage clickToFindAnotherStore() {
        $(byText("Anderen Store suchen")).click();
        return this;
    }

    @Step("click to Store suchen button")
    public LoginPage clickSearchStore() {
        $(byText("Store suchen")).click();
        return this;
    }


}
