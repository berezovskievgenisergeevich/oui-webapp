package api;

import api.model.LoginRequestLombokModel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Story("Login Appwrite - API automation")
public class LoginTests {

    @Test
    @Tags({@Tag("login"), @Tag("api")})
    @DisplayName("check 'v1/account/sessions/email' function")
    void successEmailFunctionTest() {
        LoginRequestLombokModel data = new LoginRequestLombokModel();
        data.setEmail("max.mustermann@storemind.de");
        data.setPassword("MMStore*Mind");
        Map<String, String> ouiDev = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(JSON)
                .header("x-appwrite-project", "OUI_DEV")
                .body(data)
                .post("https://appwrite.storemind.de/v1/account/sessions/email")
                .then()
                .statusCode(201)
                .log().body()
                .extract().cookies();


        given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(JSON)
                .header("x-appwrite-project", "OUI_DEV")
                .body(data)
                .cookie("a_session_oui_dev", ouiDev.get("a_session_oui_dev"))
                .cookie("a_session_oui_dev_legacy", ouiDev.get("a_session_oui_dev_legacy"))
                .get("https://appwrite.storemind.de/v1/account")
                .then()
                .statusCode(200)
                .log().body();

    }

    @Test
    @Tags({@Tag("login"), @Tag("api")})
    @DisplayName("check 'v1/account' function without cookies from 'v1/account/sessions/email'")
    void executeAccountFunctionWithoutCookiesTest() {
        LoginRequestLombokModel data = new LoginRequestLombokModel();
        data.setEmail("max.mustermann@storemind.de");
        data.setPassword("MMStore*Mind");
        String messageResponse = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(JSON)
                .header("x-appwrite-project", "OUI_DEV")
                .body(data)
                .get("https://appwrite.storemind.de/v1/account")
                .then()
                .statusCode(401)
                .log().body()
                .extract().path("message");

        assertThat(messageResponse.equals("User (role: guests) missing scope (account)"));

    }

    @Test
    void successLoginWithEmailAndPassTest() {
        LoginRequestLombokModel data = new LoginRequestLombokModel();
        data.setEmail("max.mustermann@storemind.de");
        data.setPassword("MMStore*Mind");

        String userId = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(JSON)
                .header("x-appwrite-project", "OUI_DEV")
                .body(data)
                .post("https://appwrite.storemind.de/v1/account/sessions/email")
                .then()
                .statusCode(201)
                .log().body()
                .extract()
                .cookie("a_session_oui_dev");

    }


}
