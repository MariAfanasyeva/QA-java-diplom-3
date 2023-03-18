import org.apache.commons.lang3.RandomStringUtils;

public class UserDataGenerator {

    public String genEmail() {
        return RandomStringUtils.randomAlphabetic(12).toLowerCase() + "@yandex.ru";
    }
}
