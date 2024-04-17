package web.test;

import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import web.pages.CockpitPage;
import web.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Story("[UI] Cockpit Page Automation")
public class CockpitTest extends BaseTest {
    @BeforeEach
    @DisplayName("Login to App")
    void LoginToApp() {
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
    @Tags({@Tag("cockpit"), @Tag("ui")})
    @DisplayName("Checking the existence of 'Kunden anlegen' module")
    void checkCreateNewCustomerModuleIsExists() {
        new CockpitPage().clickCreateNewCustomer();
        $("h2").shouldHave(text("Kunden anlegen"));
    }

    @Test
    @Tags({@Tag("cockpit"), @Tag("ui")})
    @DisplayName("Checking the existence of 'Kunden suchen' module")
    void checkSearchCustomerModuleIsExists() {
        new CockpitPage().clickSearchCustomer();
        $("h2").shouldHave(text("Suche"));
    }

    @Test
    @Tags({@Tag("cockpit"), @Tag("ui")})
    @DisplayName("Checking the existence of 'Produktkatalog' module")
    void checkCatalogModuleIsExists() {
        new CockpitPage().clickToProductCatalog();
        $("h2").shouldHave(text("Product Catalog"));
    }
}
