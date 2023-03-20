package pageobjects;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;

public class PersonalCabinetPage {
    //локатор для кнопки Выйти личного кабинета
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitButtonPersonalCabinetPage;

    @Step("Клик по кнопке Выйти личного кабинета")
    public void clickExitButtonPersonalCabinetPage() {
        exitButtonPersonalCabinetPage.shouldBe(visible).click();
    }
}
