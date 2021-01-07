package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {
    By Search_Results_Found_Locator = By.cssSelector(".heading-counter");
    //By Logo_Locator = By.xpath("//img [@class='logo img-responsive']");
    By Results_Grid_Locator = By.cssSelector("[class='product_list grid row']>li");
    By Continue_Shopping_Btn_Locator = By.cssSelector("[title='Continue shopping']");
    By Proceed_To_CheckOut_Btn_Locator = By.cssSelector("[title='Proceed to checkout']");

    public SearchResultPage Valid_Search_Result (){

        WebElement results =  $(Search_Results_Found_Locator);
        $(Search_Results_Found_Locator).shouldNotBe(Condition.exactText("0 results have been found."));
        System.out.println(results.getText());
        return this;
    }
    public SearchResultPage Invalid_Search_Result (){

        WebElement results =  $(Search_Results_Found_Locator);
        $(Search_Results_Found_Locator).shouldBe(Condition.exactText("0 results have been found."));
        System.out.println(results.getText());
        return this;
    }

    public SearchResultPage Results_Founds()  {
        ElementsCollection Products = $$(Results_Grid_Locator);
        System.out.println("Amount of products found as dress: " + Products.size());
       for (int i=1; i<Products.size(); i++
             ) {
                if( i< 4){
                    Integer a = i-1;
                    Products.get(a).scrollIntoView(true).hover()
                            .findElement(By.xpath("/descendant::a[@title='Add to cart']["+i+"]")).click();
                    $(Continue_Shopping_Btn_Locator).isDisplayed();
                    $(Continue_Shopping_Btn_Locator).shouldBe(Condition.enabled);
                    $(Continue_Shopping_Btn_Locator).click();
                    $(Continue_Shopping_Btn_Locator).shouldNotBe(Condition.visible);

                }if (i == 4){
                Integer a = i-1;
                Products.get(a).scrollIntoView(true).hover()
                        .findElement(By.xpath("/descendant::a[@title='Add to cart']["+i+"]")).click();
                $(Proceed_To_CheckOut_Btn_Locator).isDisplayed();
                $(Proceed_To_CheckOut_Btn_Locator).isEnabled();
                $(Proceed_To_CheckOut_Btn_Locator).click();
               $(Continue_Shopping_Btn_Locator).shouldNotBe(Condition.visible);
            }
        }
        return this;
    }
}
