package tests.ddt.redundancy;

import org.easetech.easytest.annotation.Converters;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
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

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = {"src/test/resources/registration.xml"},
        loaderType = LoaderType.XML, writeData = false)
@Converters({RegistrationDataTestConverter.class})
public class RegistrationEasyTestWithConverter {

    private WebDriver driver;
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;
    private LoginPage loginPage;

    private String url;

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
    public void registerUserTest(RegistrationTestData testData) {
        homePage.clickOnRegisterLink();
        registrationPage.inputContactInformationForm(testData.getFirstName(), testData.getLastName(),
                testData.getPhoneNumber(), testData.getEmail());
        registrationPage.inputMailingInformationForm(testData.getAddress1(), testData.getAddress2(), testData.getCity(),
                testData.getState(), testData.getZipCode(), testData.getCountry());
        registrationPage.inputUserInformationForm(testData.getUserName(), testData.getPassword(), testData.getPassword());
        registrationPage.clickOnSubmitButton();
        registrationConfirmationPage.clickOnSignInLink();
        loginPage.userLogin(testData.getUserName(), testData.getPassword());
        assertTrue(homePage.isUserIsLoggedIn());
    }

}