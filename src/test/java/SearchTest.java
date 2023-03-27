import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest extends BaseTest {
    private final String SEARCH_TEXT = "собака";
    private final StartPage startPage = new StartPage();

    @BeforeEach
    public void setUp() {
        open("/");
    }

    @Test()
    public void searchedItemsTest() {
        startPage.setSearchText(SEARCH_TEXT);
        startPage.searchResultItems.shouldBe(CollectionCondition.size(5));
        startPage.searchResultItems.shouldHave(CollectionCondition.containExactTextsCaseSensitive(SEARCH_TEXT));
    }
}
