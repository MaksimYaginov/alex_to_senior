import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@ExtendWith(TextReportExtension.class)
public class SecondTest {

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @Epic("Lala")
    @Test()
    public void secondTest(){
        open("https://ya.ru/");
        $(By.name("text")).setValue("собака").click();
        $$(By.xpath("//*[@data-type = 'fulltext']")).shouldHave(CollectionCondition.containExactTextsCaseSensitive("собака"));


    }
}
