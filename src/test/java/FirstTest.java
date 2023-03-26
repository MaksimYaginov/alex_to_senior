import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TextReportExtension.class)
public class FirstTest {

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @Epic("Lala")
    @Test()
    public void firstTest(){
        open("https://dzen.ru/");
        $$("[data-testid='news-item']").shouldBe(CollectionCondition.size(70));
    }
}
