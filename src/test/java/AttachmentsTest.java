import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;


public class AttachmentsTest {

    @Test
    public void AttachmentstestIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу Github", () -> {
            open("https://github.com");
            attachment("Sourse",webdriver().driver().source());
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
