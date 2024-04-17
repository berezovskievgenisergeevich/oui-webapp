package web.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CockpitPage {
    public CockpitPage() {
    }

    @Step("click to 'Kunden anlegen' button")
    public void clickCreateNewCustomer() {
        $(byText("Kunden anlegen")).click();
    }

    @Step("click to 'Kunden suchen' button")
    public void clickSearchCustomer() {
        $(byText("Kunden suchen")).click();
    }

    @Step("click to 'Katalog öffnen' button")
    public void clickToProductCatalog() {
        $(byText("Katalog öffnen")).click();
    }

}
