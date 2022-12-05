package quru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class WebTestWithList {
    @BeforeAll
    static void configuration() {
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
        void checkTabTest() {
            Selenide.open("https://www.lamoda.ru/");
        }

    static Stream<Arguments> selenideButtonsTest() {
        return Stream.of(
                Arguments.of("Женщинам", List.of("Идеи", "Новинки", "Одежда", "Обувь", "Аксессуары", "Бренды", "Premium","Спорт","Resale","Красота","Дом","Sale%")),
                Arguments.of("Мужчинам", List.of("Идеи", "Новинки", "Одежда", "Обувь", "Аксессуары", "Бренды", "Premium","Спорт","Resale","Красота","Дом","Sale%")),
                Arguments.of("Детям", List.of("Новинки", "Девочкам", "Мальчикам", "Малышам", "Premium", "Спорт", "Игрушки", "Дом", "Уход", "Школа", "Sale%"))
        );
    }
    @MethodSource
    @ParameterizedTest(name = "Check buttons from List {1} on site Lamoda in tabs {0}")
    @Tag("BLOCKER")
    void selenideButtonsTest(String tab, List<String> buttons) {
        $$("[role=menubar] a").find(text(tab)).click();
        $$("[class=_root_1416b_2] a").filter(visible)
                .shouldHave(CollectionCondition.texts(buttons));
    }
}
