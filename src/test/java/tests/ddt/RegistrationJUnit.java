package tests.ddt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import page.HomePage;
import page.LoginPage;
import page.RegistrationConfirmationPage;
import page.RegistrationPage;
import utils.UrlProvider;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Created by Robert_Kaszubowski on 11/16/2016.
 */
@RunWith(Parameterized.class)
public class RegistrationJUnit {

    private WebDriver driver;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;
    private LoginPage loginPage;

    private String url;

    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;
    private final String address1;
    private final String address2;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String country;
    private final String userName;
    private final String password;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Jan", "Nowak", "786675565", "nowakjan@gmail.com", "ul. Grunwaldzka 452", "Mieszkanie nr 5", "Gdansk", "Pomorskie", "80-462", "POLAND", "Jan.Nowak", "password"},
                {"Pawel", "Lubicki", "786675565", "paw44@gmail.com", "ul. Pomorksa 22", "Jakistam adres 3", "Gdynia", "Pomorskie", "82-111", "POLAND", "Paw.Lub", "password"},
                {"Michal", "Kowalski", "786675565", "kowal7@gmail.com", "ul. Lubicka52", "Kolejny adres", "Sopot", "Pomorskie", "89-333", "POLAND", "Michal55", "password"},
        });
    }

    public RegistrationJUnit(String firstName, String lastName, String phoneNumber, String email, String address1,
                             String address2, String city, String state, String zipCode, String country, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.userName = userName;
        this.password = password;
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
    public void registerUserTest() {
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
}
