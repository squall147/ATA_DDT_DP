package tests.ddt;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import page.HomePage;
import page.LoginPage;
import page.RegistrationConfirmationPage;
import page.RegistrationPage;
import utils.UrlProvider;

import static org.junit.Assert.assertTrue;

/**
 * Created by Robert_Kaszubowski on 11/16/2016.
 */
@RunWith(DataProviderRunner.class)
public class RegistrationTNGTech {

    private WebDriver driver;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;
    private LoginPage loginPage;

    private String url;

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"Jan", "Nowak", "786675565", "nowakjan@gmail.com", "ul. Grunwaldzka 452", "Mieszkanie nr 5", "Gdansk", "Pomorskie", "80-462", "POLAND", "Jan.Nowak", "password"},
                {"Pawel", "Lubicki", "786675565", "paw44@gmail.com", "ul. Pomorksa 22", "Jakistam adres 3", "Gdynia", "Pomorskie", "82-111", "POLAND", "Paw.Lub", "password"},
                {"Michal", "Kowalski", "786675565", "kowal7@gmail.com", "ul. Lubicka52", "Kolejny adres", "Sopot", "Pomorskie", "89-333", "POLAND", "Michal55", "password"},
        };
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver, HomePage.class);
        registrationPage = PageFactory.initElements(driver,
                RegistrationPage.class);
        registrationConfirmationPage = PageFactory.initElements(driver,
                RegistrationConfirmationPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);

        url = UrlProvider.PAGE_URL.getUrl();
        driver.get(url);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @UseDataProvider("data")
    public void registerUserTest(final String firstName, final String lastName, final String phoneNumber,
                                 final String email, final String address1, final String address2,
                                 final String city, final String state, final String zipCode,
                                 final String country, final String userName, final String password) {
        homePage.clickOnRegisterLink();
        registrationPage.inputContactInformationForm(firstName, lastName,
                phoneNumber, email);
        registrationPage.inputMailingInformationForm(address1, address2, city,
                state, zipCode, country);
        registrationPage.inputUserInformationForm(userName, password, password);
        registrationPage.clickOnSubmitButton();
        registrationConfirmationPage.clickOnSignInLink();
        loginPage.userLogin(userName, password);
        assertTrue(homePage.isUserIsLoggedIn());
    }

/*
    Parameters from test removed
*/

    @DataProvider
    public static Object[][] testData() {
        return new Object[][]{
                {new TestData ("Jan", "Nowak", "786675565", "nowakjan@gmail.com", "ul. Grunwaldzka 452", "Mieszkanie nr 5", "Gdansk", "Pomorskie", "80-462", "POLAND", "Jan.Nowak", "password")},
                {new TestData ("Pawel", "Lubicki", "786675565", "paw44@gmail.com", "ul. Pomorksa 22", "Jakistam adres 3", "Gdynia", "Pomorskie", "82-111", "POLAND", "Paw.Lub", "password")},
                {new TestData ("Michal", "Kowalski", "786675565", "kowal7@gmail.com", "ul. Lubicka52", "Kolejny adres", "Sopot", "Pomorskie", "89-333", "POLAND", "Michal55", "password")},
        };
    }

    @Test
    @UseDataProvider("testData")
    public void registerUserRemoveParametersTest(TestData data) {
        homePage.clickOnRegisterLink();
        registrationPage.inputContactInformationForm(data.getFirstName(), data.getLastName(),
                data.getPhoneNumber(), data.getEmail());
        registrationPage.inputMailingInformationForm(data.getAddress1(), data.getAddress2(), data.getCity(),
                data.getState(), data.getZipCode(), data.getCountry());
        registrationPage.inputUserInformationForm(data.getUserName(), data.getPassword(), data.getPassword());
        registrationPage.clickOnSubmitButton();
        registrationConfirmationPage.clickOnSignInLink();
        loginPage.userLogin(data.getUserName(), data.getPassword());
        assertTrue(homePage.isUserIsLoggedIn());
    }

    static class TestData {
        private String[] items;

        public TestData(String... items) {
            this.items = items; // should probably make a defensive copy
        }

        public String getFirstName() {
            return items[0];
        }

        public String getLastName() {
            return items[1];
        }

        public String getPhoneNumber() {
            return items[2];
        }

        public String getEmail() {
            return items[3];
        }

        public String getAddress1() {
            return items[4];
        }

        public String getAddress2() {
            return items[5];
        }

        public String getCity() {
            return items[6];
        }

        public String getState() {
            return items[7];
        }

        public String getZipCode() {
            return items[8];
        }

        public String getCountry() {
            return items[9];
        }

        public String getUserName() {
            return items[10];
        }

        public String getPassword() {
            return items[11];
        }
    }
}
