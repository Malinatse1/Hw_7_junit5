package quru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class WebTest {
    @BeforeEach
    void checkTabTest() {
        Selenide.open("https://www.lamoda.ru/");
    }

    @CsvSource(value = {
            "FARISEO,Пальто FARISEO",
            "LMC BELL TRUCKER, Куртка джинсовая LMC BELL TRUCKER",

    })
    @DisplayName("Search and check product")
    @ParameterizedTest(name = "Check {0}, result will be {1}")
    @Tag("BLOCKER")
    void ozonTabTest(String searchProduct, String expectedProduct) {
        $("[type =button]").click();
        $("[type =text]").setValue(searchProduct).pressEnter();
        $("[class = x-product-card-description__product-name]").shouldHave(text(expectedProduct));
    }
}
