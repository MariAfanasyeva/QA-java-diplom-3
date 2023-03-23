package pageobjects;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    //локатор кнопки Войти страницы авторизации
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    public SelenideElement loginButtonLoginPage;
    //локатор инпута Email страницы авторизации
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailFieldLoginPage;
    //локатор инпута Password страницы авторизации
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordFieldLoginPage;
    //линк Регистрация страницы авторизации
    @FindBy(how = How.XPATH, using = ".//a[@href='/register']")
    private SelenideElement registrationLinkLoginPage;
    //линк Восстановить пароль страницы авторизации
    @FindBy(how = How.XPATH, using = ".//a[@href='/forgot-password']")
    private SelenideElement restorePasswordLinkLoginPage;

    @Step("Заполнение инпута email")
    public void setEmailFieldLoginPage(String email) {
        emailFieldLoginPage.setValue(email);
    }

    @Step("Заполнение инпута пароля")
    public void setPasswordFieldLoginPage(String password) {
        passwordFieldLoginPage.setValue(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickLoginButtonLoginPage() {
        loginButtonLoginPage.click();
    }

    @Step("Клик по линку Регистрация")
    public void clickRegistrationLinkLoginPage() {
        registrationLinkLoginPage.click();
    }

    @Step("Клик по линку Восстановить пароль")
    public void clickRestorePasswordLinkLoginPage() {
        restorePasswordLinkLoginPage.click();
    }

    @Step("Авторизация MainPage")
    public MainPage login(String email, String password) {
        setEmailFieldLoginPage(email);
        setPasswordFieldLoginPage(password);
        clickLoginButtonLoginPage();
        return page(MainPage.class);
    }

    @Step("Авторизации ResetPasswordPage")
    public ResetPasswordPage loginForResetPasswordPage(String email, String password) {
        setEmailFieldLoginPage(email);
        setPasswordFieldLoginPage(password);
        clickLoginButtonLoginPage();
        return page(ResetPasswordPage.class);
    }
}
