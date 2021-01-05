package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.elements;

public class SearchResultPage {
    By Search_Results_Found_Locator = By.cssSelector(".heading-counter");
    By Logo_Locator = By.xpath("//img [@class='logo img-responsive']");
    public SearchResultPage Valid_Search_Result (){

        WebElement results =  $(Search_Results_Found_Locator);
        $(Search_Results_Found_Locator).shouldNotBe(Condition.exactText("0 results have been found."));
        System.out.println(results.getText());
        $(Logo_Locator).click();
        return this;
    }
    public SearchResultPage Invalid_Search_Result (){

        WebElement results =  $(Search_Results_Found_Locator);
        $(Search_Results_Found_Locator).shouldBe(Condition.exactText("0 results have been found."));
        System.out.println(results.getText());
        $(Logo_Locator).click();
        return this;
    }
}
