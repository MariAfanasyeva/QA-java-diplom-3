import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.PersonalCabinetPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PersonalCabinetTest {
    @Before
    public void browserSettings (){
        //Configuration.holdBrowserOpen = true; //если нужно НЕ закрывать браузер после теста, оставить эту сроку
        Configuration.startMaximized = true; //полноразмерное окно браузера
    }
    @Test
    @DisplayName("Проверка перехода по клику в Личный Кабинет и выхода из аккаунта по кнопке «Выйти».")
    public void checkClickExitButtonPersonalCabinetPageRedirectToLoginPage(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        LoginPage loginPage = mainPage.clickLoginAccountButtonMainPage();
        loginPage.login("qwerty123@yandex.ru", "qwerty123");
        PersonalCabinetPage personalCabinetPage = mainPage.clickPersonalCabinetButtonMainPage();
        personalCabinetPage.clickExitButtonPersonalCabinetPage();
        loginPage.loginButtonLoginPage.shouldBe(visible);
        Assert.assertTrue(url().equals("https://stellarburgers.nomoreparties.site/login"));//проверить на каком мы урле
    }
    @Test
    @DisplayName("Проверка перехода по клику в Личный Кабинет и из него на главную через клик по Лого")
    public void checkRedirectBetweenPersonalCabinetAndLogo(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        LoginPage loginPage = mainPage.clickLoginAccountButtonMainPage();
        loginPage.login("qwerty123@yandex.ru", "qwerty123");
        PersonalCabinetPage personalCabinetPage = mainPage.clickPersonalCabinetButtonMainPage();
        mainPage.clickLogoMainPage();
        mainPage.bunKratorianTabMainPage.shouldBe(visible);//проверили что видим Булку из Конструктора на главной странице
        personalCabinetPage = mainPage.clickPersonalCabinetButtonMainPage();
        personalCabinetPage.clickExitButtonPersonalCabinetPage();
        mainPage.clickPersonalCabinetButtonMainPage();//убедились что из аккаунта успешно вышли тк иначе кнопка была бы "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка перехода по клику в Личный Кабинет и из него через клик в Конструктор")
    public void checkRedirectBetweenPersonalCabinetAndConstructor() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site",
                MainPage.class);
        LoginPage loginPage = mainPage.clickLoginAccountButtonMainPage();
        loginPage.login("qwerty123@yandex.ru", "qwerty123");
        PersonalCabinetPage personalCabinetPage = mainPage.clickPersonalCabinetButtonMainPage();
        mainPage.clickConstructorButtonMainPage();
        mainPage.bunKratorianTabMainPage.shouldBe(visible);//проверили что видим Булку из Конструктора на главной странице
        personalCabinetPage = mainPage.clickPersonalCabinetButtonMainPage();
        personalCabinetPage.clickExitButtonPersonalCabinetPage();
        mainPage.clickPersonalCabinetButtonMainPage();//убедились что из аккаунта успешно вышли тк иначе кнопка была бы "Оформить заказ"
    }

}
