package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

    public class HomePage {
        By Store_info_Locator = By.xpath("//section[@id='block_contact_infos']/div/ul/li");
        By Search_Box_Locator = By.cssSelector("#search_query_top");
        By Chiffon_Dress_Locator = By.cssSelector(".product-name[title='Printed Chiffon Dress']");


        public HomePage Selected_Product_From_Homepage (){
            $(Chiffon_Dress_Locator).scrollIntoView(true).click();
            return this;
        }

   public HomePage Search_For_Valid_Product(){
       $(Search_Box_Locator).clear();
       $(Search_Box_Locator).setValue("Dress").pressEnter();
       return this;
   }

   public HomePage Search_For_Invalid_Product(){
       $(Search_Box_Locator).clear();
       $(Search_Box_Locator).setValue("Wedding dress").pressEnter();
       return this;
   }

    //Method to scroll down where store information is located, this method can be added to Get_Store_Information
    //To reduce code
    public HomePage find_Store_Information(){
        $(Store_info_Locator).scrollIntoView(true);
        return this;
    }

    //Validated store information from address, phone and email
    public HomePage Get_Store_Information(){
        ElementsCollection Information = $$(Store_info_Locator);
        System.out.println(Information.get(0).should(Condition.text("Selenium Framework, Research Triangle Park, North Carolina, USA")));
        System.out.println(Information.get(1).shouldBe(Condition.exactText("Call us now: (347) 466-7432")));
        System.out.println(Information.get(2).shouldHave(Condition.exactText("Email: support@seleniumframework.com")));
        return this;
    }
}
