package design.patterns.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Robert_Kaszubowski on 11/21/2016.
 */
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "userName")
    private WebElement usernameLocator;

    @FindBy(name = "password")
    private WebElement passwordLocator;

    @FindBy(name = "login")
    private WebElement loginButtonLocator;

    @FindBy(id = "signOffLinkElement")
    private WebElement signOffLinkLocator;

    public void userLogin(String UserName, String Password) {
        usernameLocator.sendKeys(UserName);
        passwordLocator.sendKeys(Password);
        loginButtonLocator.click();
    }

    public boolean isUserIsLoggedIn() {
        return signOffLinkLocator.isDisplayed();
    }

}
