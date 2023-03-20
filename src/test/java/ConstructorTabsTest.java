import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobjects.MainPage;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTabsTest {
    @Before
    public void browserSettings() {
        //Configuration.holdBrowserOpen = true;
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Проверка что выбрана таба Соусы")
    public void sauceTabExistAndClicable() {
        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site",
                        MainPage.class);
        String result = mainPage.returnSauceTabClassName();
        Assert.assertTrue(result.contains("current"));
    }

    @Test
    @DisplayName("Проверка что выбрана таба Начинки")
    public void fillingTabExistAndAndClicable() {
        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site",
                        MainPage.class);
        String result1 = mainPage.returnFillingTabClassName();
        Assert.assertTrue(result1.contains("current"));
    }

    @Test
    @DisplayName("Проверка что выбрана таба Булки через переключение между табами")
    public void bunsTabExistAndClicable() {
        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site",
                        MainPage.class);
        String result1 = mainPage.returnFillingTabClassName();
        String result2 = mainPage.returnBunsTabClassName();
        Assert.assertTrue(result2.contains("current"));
    }

    @Test
    @DisplayName("Проверка, что конструктор имеет доступный ингридиент")
    public void constructorShouldHaveSomeIngridients() {
        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site",
                        MainPage.class);
        mainPage.bunKratorianTabMainPage.shouldBe(enabled).click();
    }

}
