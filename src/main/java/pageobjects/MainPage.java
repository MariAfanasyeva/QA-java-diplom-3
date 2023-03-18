package pageobjects;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
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
    //локатор для конкретной Булки с главной страницы
    @FindBy(how = How.XPATH, using = ".//img[@alt='Краторная булка N-200i']/parent::a")
    public SelenideElement bunKratorianTabMainPage;
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;
    //оставила эти локаторы ниже на случай если в последствии они потребуются для других тестов, т.е. на будущее
//    //локатор для конкретного Соуса с главной страницы
//    @FindBy(how = How.XPATH, using = ".//img[@alt='Соус традиционный галактический']/parent::a")
//    public SelenideElement sauceGalacticTabMainPage;
//    //локатор для конкретной Начинки с главной страницы
//    @FindBy(how = How.XPATH, using = ".//img[@alt='Сыр с астероидной плесенью']/parent::a")
//    public SelenideElement fillingCheeseTabMainPage;

    //метод для перехода на главную страницу через клик по лого
    public void clickLogoMainPage(){
        logoMainPage.click();
    }
    //метод для клика по кнопке Личный кабинет
    public PersonalCabinetPage clickPersonalCabinetButtonMainPage(){

        personalCabinetButtonMainPage.click();
        return page(PersonalCabinetPage.class);
    }
    //метод для клика по кнопке Войти в аккаунт LoginPage
    public LoginPage clickLoginAccountButtonMainPage(){
        loginAccountButtonMainPage.click();
        return page(LoginPage.class);
    }
    //метод для клика по кнопке Конструктор
    public void clickConstructorButtonMainPage(){
        constructorButtonMainPage.click();
    }
    //метод для проверки, что текущий раздел -  Булки
    public String returnBunsTabClassName() {
        bunTabMainPage.click();
        String attribute2 = bunTabMainPage.getAttribute("class");
        return attribute2;
    }

    //метод для проверки, что текущий раздел - Соусы
    public String returnSauceTabClassName() {
        sauceTabMainPage.click();
        String attribute = sauceTabMainPage.getAttribute("class");
        return attribute;
    }
    //метод для проверки, что текущий раздел -  Начинки
    public String  returnFillingTabClassName() {
        fillingTabMainPage.click();
        String attribute1 = fillingTabMainPage.getAttribute("class");
        return attribute1;
    }
}
