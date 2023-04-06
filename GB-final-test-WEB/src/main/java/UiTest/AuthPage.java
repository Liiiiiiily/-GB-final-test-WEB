package UiTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends AbstractPage {

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement input_username;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement input_password;
    @FindBy(xpath = "//button[@form='login']")
    private WebElement button_login;
    @FindBy(xpath = "//div[@class='error-block svelte-uwkxn9']/h2")
    private WebElement error_code;
    @FindBy(xpath = "//div[@class='error-block svelte-uwkxn9']/p[1]")
    private WebElement error_message;
    @FindBy(xpath = "//li[contains(@class, 'surface')]")
    private WebElement button_hello;

    public AuthPage loginValid() {
        input_username.sendKeys("+79277371622");
        input_password.sendKeys("e27a7bac9b");
        button_login.click();
        return this;
    }
    public AuthPage loginMinChar() {
        input_username.sendKeys("tre");
        input_password.sendKeys("ad57484016");
        button_login.click();
        return this;
    }
    public AuthPage loginMaxChar() {
        input_username.sendKeys("maximumlenghtsymbols");
        input_password.sendKeys("56dfgs");
        button_login.click();
        return this;
    }
    public AuthPage loginRus() {
        input_username.sendKeys("юзернейм");
        input_password.sendKeys("pup");
        button_login.click();
        return this;
    }
    public AuthPage loginSpecChar() {
        input_username.sendKeys("*&$^&");
        input_password.sendKeys("htdr5");
        button_login.click();
        return this;
    }
    public AuthPage loginLessThanMinChar() {
        input_username.sendKeys("ww");
        input_password.sendKeys("ad57484016");
        button_login.click();
        return this;
    }
    public AuthPage loginMoreThanMaxChar() {
        input_username.sendKeys("202020202020202020201");
        input_password.sendKeys("gsh54syrg");
        button_login.click();
        return this;
    }

    public AuthPage loginIncorrectPassword() {
        input_username.sendKeys("+79277371622");
        input_password.sendKeys("5463");
        button_login.click();
        return this;
    }
    public AuthPage loginWithoutLoginAndPassword() {
        input_username.sendKeys("");
        input_password.sendKeys("");
        button_login.click();
        return this;
    }
    public String getLogin() {
        String login = button_hello.getText().substring(7);
        return login;
    }
    public WebElement getError_code() {
        return error_code;
    }
    public WebElement getError_message() {
        return error_message;
    }
}
