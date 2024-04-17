package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"
})
public interface TestsConfig extends Config {
    @Key("browser")
    String browser();

    @Key("browser.size")
    String browserSize();

    @Key("app.url")
    String baseUrl();

    @Key("browser.version")
    String browserVersion();

    @Key("app.email")
    String email();

    @Key("app.pass")
    String pass();

    @Key("app.store_id")
    String storeId();

    @Key("api.url")
    String apiUrl();

    @Key("api.project.name")
    String apiProjectName();

    @Key("remote")
    Boolean isRemote();
}
