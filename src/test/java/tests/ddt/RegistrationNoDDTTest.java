package tests.ddt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import page.HomePage;
import page.LoginPage;
import page.RegistrationConfirmationPage;
import page.RegistrationPage;
import utils.UrlProvider;

import static org.junit.Assert.assertTrue;

public class RegistrationNoDDTTest {

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
	public void registerUser1Test() {
		final String userName = "Jan.Nowak";
		final String password = "password";
		final String firstName = "Jan";
		final String lastName = "Nowak";
		final String phoneNumber = "786675565";
		final String email = "nowakjan@gmail.com";
		final String address1 = "ul. Grunwaldzka 452";
		final String address2 = "Mieszkanie nr 5";
		final String city = "Gdansk";
		final String state = "Pomorskie";
		final String zipCode = "80-462";
		final String country = "POLAND";

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

	@Test
	public void registerUser2Test() {
		final String userName = "Robert.Lubicz";
		final String password = "password";
		final String firstName = "Robert";
		final String lastName = "Lubicz";
		final String phoneNumber = "234657678";
		final String email = "lubiczRobert@gmail.com";
		final String address1 = "ul. Swietojanska 232";
		final String address2 = "Mieszkanie nr 10";
		final String city = "Gdynia";
		final String state = "Pomorskie";
		final String zipCode = "80-439";
		final String country = "POLAND";

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

	@Test
	public void registerUser3Test() {
		final String username = "Tomasz.Kowalski";
		final String password = "password2";
		final String firstName = "Tomasz";
		final String lastName = "Kowalski";
		final String phoneNumber = "123546765";
		final String email = "kowalskitomasz@gmail.com";
		final String address1 = "ul. Sobieskiego 132";
		final String address2 = "Mieszkanie nr 2";
		final String city = "Gdynia";
		final String state = "Pomorskie";
		final String zipCode = "80-432";
		final String country = "POLAND";

		homePage.clickOnRegisterLink();
		registrationPage.inputContactInformationForm(firstName, lastName,
				phoneNumber, email);
		registrationPage.inputMailingInformationForm(address1, address2, city,
				state, zipCode, country);
		registrationPage.inputUserInformationForm(username, password, password);
		registrationPage.clickOnSubmitButton();
		registrationConfirmationPage.clickOnSignInLink();
		loginPage.userLogin(username, password);
		assertTrue(homePage.isUserIsLoggedIn());
	}
}
