package pageobjects;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    //локатор для конкретной Булки с главной страницы
    @FindBy(how = How.XPATH, using = ".//img[@alt='Краторная булка N-200i']/parent::a")
    public SelenideElement bunKratorianTabMainPage;
    //локатор для логотипа Стеллар Бургерс главной страницы (переход на главную страницу)
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'logo')]/a[@href='/']")
    private SelenideElement logoMainPage;
    //локатор для кнопки Личный Кабинет главной страницы
    @FindBy(how = How.XPATH, using = ".//a[@href = '/account']")
    private SelenideElement personalCabinetButtonMainPage;
    //локатор для кнопки Войти в аккаунт главной страницы
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginAccountButtonMainPage;
    //локатор для кнопки Конструктор главной страницы
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']/parent::a")
    private SelenideElement constructorButtonMainPage;
    //локаторы для табов с Игридиентами Булки главной страницы
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']/parent::div")
    private SelenideElement bunTabMainPage;
    //локаторы для табов с Игридиентами Соусы главной страницы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']/parent::div")
    private SelenideElement sauceTabMainPage;
    //локаторы для табов с Игридиентами Начинки главной страницы
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']/parent::div")
    private SelenideElement fillingTabMainPage;
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @Step("Переход на главную страницу через клик по лого")
    public void clickLogoMainPage() {
        logoMainPage.click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public PersonalCabinetPage clickPersonalCabinetButtonMainPage() {

        personalCabinetButtonMainPage.click();
        return page(PersonalCabinetPage.class);
    }

    @Step("Клик по кнопке Войти в аккаунт LoginPage")
    public LoginPage clickLoginAccountButtonMainPage() {
        loginAccountButtonMainPage.click();
        return page(LoginPage.class);
    }

    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButtonMainPage() {
        constructorButtonMainPage.click();
    }

    @Step("Проверка, что текущий раздел - Булки")
    public String returnBunsTabClassName() {
        bunTabMainPage.click();
        String attribute2 = bunTabMainPage.getAttribute("class");
        return attribute2;
    }

    @Step("Проверка, что текущий раздел - Соусы")
    public String returnSauceTabClassName() {
        sauceTabMainPage.click();
        String attribute = sauceTabMainPage.getAttribute("class");
        return attribute;
    }

    @Step("Проверка, что текущий раздел - Начинки")
    public String returnFillingTabClassName() {
        fillingTabMainPage.click();
        String attribute1 = fillingTabMainPage.getAttribute("class");
        return attribute1;
    }
}
