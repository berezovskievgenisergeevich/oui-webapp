package web.data;

import com.github.javafaker.Faker;
import config.TestsConfig;
import helpers.StoreProvider;
import org.aeonbits.owner.ConfigFactory;
import web.data.model.Store;

import java.util.Locale;

public class TestData {
    private final TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());
    private final Faker faker = new Faker(new Locale("en-US"));
    public final String MAIL = config.email();
    public final String PASS = config.pass();
    public final String STORE_ID = config.storeId();
    public final String RANDOM_EMAIL = faker.internet().emailAddress();
    public final String RANDOM_PASS = faker.internet().password();
    public static final String INVALID_STORE_ID = "INVALID_STORE_ID";
    public Store[] stores = StoreProvider.stores;
}
