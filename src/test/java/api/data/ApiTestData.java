package api.data;

import api.model.LoginRequestModel;
import com.github.javafaker.Faker;
import config.TestsConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.Locale;

public class ApiTestData {
    private final TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());
    private final Faker faker = new Faker(new Locale("en-US"));
    public final String RANDOM_EMAIL = faker.internet().emailAddress();
    public final String RANDOM_PASS = faker.internet().password();
    public final LoginRequestModel bodyData = new LoginRequestModel(config.email(), config.pass());

}
