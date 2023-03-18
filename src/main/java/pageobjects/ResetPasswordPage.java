package pageobjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class ResetPasswordPage {
    //локатор для линка Войти страницы Восстановления пароля
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLinkResetPesswordPage;
    //метод для клика по кнопке Войти страницы Восстановления пароля
    public LoginPage clickloginLinkResetPesswordPage(){
        loginLinkResetPesswordPage.click();
        return page(LoginPage.class);
    }
}
