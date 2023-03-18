import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageobjects.*;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @Before
    public void browserSettings (){
        //Configuration.holdBrowserOpen = true; //если нужно НЕ закрывать браузер после теста, оставить эту сроку
        Configuration.startMaximized = true; //полноразмерное окно браузера
    }

    @Test
    @DisplayName("Проверка входа в систему по клику на Войти в аккаунт с главной страницы")
    public void enterWithClickLoginButtonInMainPage(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        LoginPage loginPage = mainPage.clickLoginAccountButtonMainPage();
        loginPage.login("qwerty123@yandex.ru", "qwerty123");
        PersonalCabinetPage personalCabinetPage = mainPage.clickPersonalCabinetButtonMainPage();
        personalCabinetPage.clickExitButtonPersonalCabinetPage();
        mainPage.clickPersonalCabinetButtonMainPage();//убедились что из аккаунта успешно вышли тк иначе кнопка была бы "Оформить заказ"
    }
    @Test
    @DisplayName("Проверка входа через страницу Восстановления пароля по линку Войти")
         public void enterWithLinkInResetPasswordPage() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        LoginPage loginPage = mainPage.clickLoginAccountButtonMainPage();
        loginPage.clickRestorePasswordLinkLoginPage();//после этого шага мы на странице забыли пароль
        ResetPasswordPage resetPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password",
                ResetPasswordPage.class);
        loginPage = resetPasswordPage.clickloginLinkResetPesswordPage();
        loginPage.loginForResetPasswordPage("qwerty123@yandex.ru", "qwerty123");
        PersonalCabinetPage personalCabinetPage = mainPage.clickPersonalCabinetButtonMainPage();
        personalCabinetPage.clickExitButtonPersonalCabinetPage();
        mainPage.clickPersonalCabinetButtonMainPage();//убедились что из аккаунта успешно вышли тк иначе кнопка была бы "Оформить заказ"
    }
    @Test
    @DisplayName("Проверка входа в систему с существующими логином и паролем со страницы Авторизации")
            public void enterWithValidDataInLoginPage() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        LoginPage loginPage = mainPage.clickLoginAccountButtonMainPage();
        loginPage.clickRegistrationLinkLoginPage();
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register",
                RegistrationPage.class);
        loginPage = registrationPage.clickLoginLinkRegPage1();
        loginPage.login("qwerty123@yandex.ru", "qwerty123");
        PersonalCabinetPage personalCabinetPage = mainPage.clickPersonalCabinetButtonMainPage();
        personalCabinetPage.clickExitButtonPersonalCabinetPage();
        mainPage.clickPersonalCabinetButtonMainPage();//убедились что из аккаунта успешно вышли тк иначе кнопка была бы "Оформить заказ"
    }
    @Test
    @DisplayName("Проверка входа через Личный кабинет")
            public void enterWithPersonalCabinet() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        PersonalCabinetPage loginPage = mainPage.clickPersonalCabinetButtonMainPage();//после этого шага я на логине
        LoginPage loginPage1 = open("https://stellarburgers.nomoreparties.site/login",
                LoginPage.class);
        loginPage1.login("qwerty123@yandex.ru", "qwerty123");
        PersonalCabinetPage personalCabinetPage = mainPage.clickPersonalCabinetButtonMainPage();
        personalCabinetPage.clickExitButtonPersonalCabinetPage();
        mainPage.clickPersonalCabinetButtonMainPage();//убедились что из аккаунта успешно вышли тк иначе кнопка была бы "Оформить заказ"
    }
}
