package pageobjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    //локатор инпута Email страницы авторизации
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailFieldLoginPage;
    //локатор инпута Password страницы авторизации
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordFieldLoginPage;
    //локатор кнопки Войти страницы авторизации
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    public SelenideElement loginButtonLoginPage;
    //линк Регистрация страницы авторизации
    @FindBy(how = How.XPATH, using = ".//a[@href='/register']")
    private SelenideElement registrationLinkLoginPage;
    //линк Восстановить пароль страницы авторизации
    @FindBy(how = How.XPATH, using = ".//a[@href='/forgot-password']")
    private SelenideElement restorePasswordLinkLoginPage;

    // метод заполнения инпута email
    public void setEmailFieldLoginPage(String email) {
        emailFieldLoginPage.setValue(email);
    }

    // метод заполнения интупа пароля
    public void setPasswordFieldLoginPage(String password) {
        passwordFieldLoginPage.setValue(password);
    }

    // метод клика по кнопке Войти
    public void clickLoginButtonLoginPage() {
        loginButtonLoginPage.click();
    }

    //метод клика по линку Регистрация
    public void clickRegistrationLinkLoginPage() {
        registrationLinkLoginPage.click();
    }

    //метод клика по линку Восстановить пароль
    public void clickRestorePasswordLinkLoginPage() {
        restorePasswordLinkLoginPage.click();
    }

    //метод для авторизация
    public MainPage login(String email, String password) {
        setEmailFieldLoginPage(email);
        setPasswordFieldLoginPage(password);
        clickLoginButtonLoginPage();
        return page(MainPage.class);
    }

    //метод для авторизации ResetPasswordPage
    public ResetPasswordPage loginForResetPasswordPage(String email, String password) {
        setEmailFieldLoginPage(email);
        setPasswordFieldLoginPage(password);
        clickLoginButtonLoginPage();
        return page(ResetPasswordPage.class);
    }
}
