package design.patterns.factory;

import design.patterns.factory.page.LoginPage;
import design.patterns.factory.page.SomeOtherPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Robert_Kaszubowski on 11/21/2016.
 */
public class FactoryForPO {

    private final WebDriver driver;

    private LoginPage loginPage;
    private SomeOtherPage someOtherPage;

    public FactoryForPO(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = PageFactory.initElements(driver, LoginPage.class);
        }
        return loginPage;
    }

    public SomeOtherPage getSomeOtherPage() {
        if (someOtherPage == null) {
            someOtherPage = PageFactory.initElements(driver, SomeOtherPage.class);
        }
        return someOtherPage;
    }

}
