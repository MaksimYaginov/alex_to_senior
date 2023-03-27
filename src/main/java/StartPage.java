import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StartPage {
    SelenideElement searchField = $(By.name("text"));
    ElementsCollection searchResultItems = $$(By.cssSelector("li.mini-suggest__item"));

    public StartPage setSearchText(String text) {
        searchField.setValue(text).click();
        return this;
    }
}
