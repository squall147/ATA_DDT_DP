package design.patterns.factory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.UrlProvider;

/**
 * Created by Robert_Kaszubowski on 11/21/2016.
 */
public class HowToUseFactory {

    private WebDriver driver;
    private FactoryForPO factoryForPO;
    private String url;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

/*      We do not need this code any more:

        homePage = PageFactory.initElements(driver, HomePage.class);
        registrationPage = PageFactory.initElements(driver,
                RegistrationPage.class);
        registrationConfirmationPage = PageFactory.initElements(driver,
                RegistrationConfirmationPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
*/

        factoryForPO = new FactoryForPO(driver);

        url = UrlProvider.PAGE_URL.getUrl();
        driver.get(url);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void factoryUsageTest() {
        factoryForPO.getSomeOtherPage().printHello();
    }

}
