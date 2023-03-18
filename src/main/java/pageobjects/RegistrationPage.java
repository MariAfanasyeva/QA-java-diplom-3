package pageobjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    //локатор инпута Имя страницы регистрации
    @FindBy(how = How.XPATH, using = ".//div[.//label[text()='Имя']][contains(@class, 'text')]/input")
    private SelenideElement nameFieldRegPage;
    //локатор поля Емаил страницы регистрации
    @FindBy(how = How.XPATH, using = ".//div[.//label[text()='Email']][contains(@class, 'text')]/input")
    private SelenideElement emailFieldRegPage;
    //локатор поля Пароль страницы регистрации
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordFieldRegPage;
    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement regButtonRegPage;
    //локатор кнопки Войти со страницы регистрации
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLinkRegPage;
    //локатор для ошибки о Некорректном пароле
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement passwordErrorValidateRegPage;
    //метод заполнения поля имя
    public void setNameFieldRegPage(String name) {
        nameFieldRegPage.setValue(name);
    }
    // метод заполнения поля email
    public void setEmailFieldRegPage(String email) {
        emailFieldRegPage.setValue(email);
    }
    // метод заполнения поля пароля
    public void setPasswordFieldRegPage(String password) {
        passwordFieldRegPage.setValue(password);
    }
    // метод клика по кнопке Зарегистрироваться
    public void clickRegInButton() {
        regButtonRegPage.click();
    }

    // метод регистрации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void register(String name, String email, String password){
        setNameFieldRegPage(name);
        setEmailFieldRegPage(email);
        setPasswordFieldRegPage(password);
        clickRegInButton();
    }
    //метод для проверки что выводится информация о Некорректном пароле (обязательное минимальное количество символов должно соблюдаться)
    public void checkUncorrectPassword(){
        Selenide.$(Selectors.byXpath(".//p[text()='Некорректный пароль']")).shouldHave(Condition.exactText("Некорректный пароль"));
    }
    //метод клика по линку Войти LoginPage
    public LoginPage clickLoginLinkRegPage1(){
        loginLinkRegPage.click();
        return page(LoginPage.class);
    }
}
