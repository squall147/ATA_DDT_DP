package tests.ddt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.RegistrationConfirmationPage;
import page.RegistrationPage;
import utils.UrlProvider;

import static org.junit.Assert.assertTrue;

/**
 * Created by Robert_Kaszubowski on 11/16/2016.
 */
public class RegistrationTestNG {

    private WebDriver driver;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;
    private LoginPage loginPage;

    private String url;

    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]{
                {"Jan", "Nowak", "786675565", "nowakjan@gmail.com", "ul. Grunwaldzka 452", "Mieszkanie nr 5", "Gdansk", "Pomorskie", "80-462", "POLAND", "Jan.Nowak", "password"},
                {"Pawel", "Lubicki", "786675565", "paw44@gmail.com", "ul. Pomorksa 22", "Jakistam adres 3", "Gdynia", "Pomorskie", "82-111", "POLAND", "Paw.Lub", "password"},
                {"Michal", "Kowalski", "786675565", "kowal7@gmail.com", "ul. Lubicka52", "Kolejny adres", "Sopot", "Pomorskie", "89-333", "POLAND", "Michal55", "password"},
        };
    }

/*
    Remember that @BeforeTest will not work if you have multiple data.
*/

    @BeforeMethod
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

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test(dataProvider = "data")
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
}
