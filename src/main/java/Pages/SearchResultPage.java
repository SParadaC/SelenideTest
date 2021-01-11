package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    By Search_Results_Found_Locator = By.cssSelector(".heading-counter");
    //By Logo_Locator = By.xpath("//img [@class='logo img-responsive']");
    By Results_Grid_Locator = By.cssSelector("[class='product_list grid row']>li");
    By Continue_Shopping_Btn_Locator = By.cssSelector("[title='Continue shopping']");
    By Proceed_To_CheckOut_Btn_Locator = By.cssSelector("[title='Proceed to checkout']");
   By Grid_Option_Locator = By.cssSelector(".icon-th-large");
    By List_Option_Locator = By.cssSelector(".icon-th-list");
    By Results_List_Locator = By.cssSelector("[class='product_list row list']>li>div>div");

    //After searching the results found should be more than 0
    public SearchResultPage Valid_Search_Result() {

        WebElement results = $(Search_Results_Found_Locator);
        $(Search_Results_Found_Locator).shouldNotBe(Condition.exactText("0 results have been found."));
        System.out.println(results.getText());
        return this;
    }


    //After searching for a no existing product there should be 0 results
    public SearchResultPage Invalid_Search_Result() {

        WebElement results = $(Search_Results_Found_Locator);
        $(Search_Results_Found_Locator).shouldBe(Condition.exactText("0 results have been found."));
        System.out.println(results.getText());
        return this;
    }

    //After results has been found you should be able to interact with the items in the grid

    public SearchResultPage Results_Founds() {
        ElementsCollection Products = $$(Results_Grid_Locator);
        System.out.println("Amount of products found as dress: " + Products.size());
        for (int i = 1; i < Products.size(); i++
        ) {
            if (i < 4) {
                Integer a = i - 1;
                Products.get(a).scrollIntoView(true).hover()
                        .findElement(By.xpath("/descendant::a[@title='Add to cart'][" + i + "]")).click();
                $(Continue_Shopping_Btn_Locator).isDisplayed();
                $(Continue_Shopping_Btn_Locator).shouldBe(Condition.enabled);
                $(Continue_Shopping_Btn_Locator).click();
                $(Continue_Shopping_Btn_Locator).shouldNotBe(Condition.visible);

            }
            if (i == 4) {
                Integer a = i - 1;
                Products.get(a).scrollIntoView(true).hover()
                        .findElement(By.xpath("/descendant::a[@title='Add to cart'][" + i + "]")).click();
                $(Proceed_To_CheckOut_Btn_Locator).isDisplayed();
                $(Proceed_To_CheckOut_Btn_Locator).isEnabled();
                $(Proceed_To_CheckOut_Btn_Locator).click();
                $(Continue_Shopping_Btn_Locator).shouldNotBe(Condition.visible);
            }
        }
        return this;
    }
    public SearchResultPage Select_Grid() {
        $(Grid_Option_Locator).should(Condition.exist).shouldBe(Condition.visible).click();
        return this;
    }

    public SearchResultPage Select_List() {
        $(List_Option_Locator).should(Condition.exist).shouldBe(Condition.visible).click();
        return this;
    }

    public SearchResultPage Results_By_List() {

        ElementsCollection Products = $$(Results_List_Locator);
        for (SelenideElement product : Products) {
            Integer Btn_Locator = Products.indexOf(product) + 1;

            product.scrollIntoView(true).$(By.xpath("(//a[@title='Add to cart'])[" + Btn_Locator + "]")).click();
            if (Products.indexOf(product)==6){
                $(Proceed_To_CheckOut_Btn_Locator).isDisplayed();
                $(Proceed_To_CheckOut_Btn_Locator).isEnabled();
                $(Proceed_To_CheckOut_Btn_Locator).click();
            }else {
                $(Continue_Shopping_Btn_Locator).should(Condition.exist).shouldBe(Condition.visible).click();
                $(Continue_Shopping_Btn_Locator).shouldNotBe(Condition.visible);
            }

        }
        return this;
    }

}
