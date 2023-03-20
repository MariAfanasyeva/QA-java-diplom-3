import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.RegistrationPage;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPageTest {
    @Before
    public void browserSettings() {
        //Configuration.holdBrowserOpen = true; //если нужно НЕ закрывать браузер после теста, оставить эту сроку
        Configuration.startMaximized = true; //полноразмерное окно браузера
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля менее 6 символов")
    public void registrationWithUnValidPassword() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        LoginPage loginPage = mainPage.clickLoginAccountButtonMainPage();
        loginPage.clickRegistrationLinkLoginPage();
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register",
                RegistrationPage.class);
        registrationPage.register("mary", "afana@yandex.ru", "qwe");
        registrationPage.checkUncorrectPassword();
    }

    @Test
    @DisplayName("Проверка успешной авторизации с валидной длинной пароля и заполненными обязательными полями")
    public void registrationWithValidPassword() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        LoginPage loginPage = mainPage.clickLoginAccountButtonMainPage();
        loginPage.clickRegistrationLinkLoginPage();//после этого шага мы на странице забыли пароль
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register",
                RegistrationPage.class);
        UserDataGenerator userDataGenerator = new UserDataGenerator();
        String email = userDataGenerator.genEmail();
        registrationPage.register("mary", email, "afamary");
        //нужно залогиниться с новыми данными
        loginPage.login(email, "afamary");//успешно залогинились, следовательно проверили, что пользователь был создан
    }
}
