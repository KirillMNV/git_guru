import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class NewTest {
    @Test
    void newTest() {
        System.out.println("Best test eva");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    public void testIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу Github", () -> {
            open("https://github.com");
        });
        step("Нажимаем на поисковую строку", () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
        });
        step("Вписываем нужную инфу и поддтверждаем", () -> {
            $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
            $("#query-builder-test").pressEnter();
        });


    }
}
