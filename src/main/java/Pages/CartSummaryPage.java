package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartSummaryPage {

//Order of execution matter is recommended staring from the fourth to the second
//Use the Cart menu when only 1 product is in the cart
By Quantity_TextBox_Fourth_Product_Locator = By.xpath("(//input[@class='cart_quantity_input form-control grey'])[4]");
By Minus_Button_Third_Product = By.xpath("(//a[@title='Subtract'])[3]");
By Bin_Button_Second_Element = By.xpath("(//a[@title='Delete'])[2]");
//For last product in the cart
By Cart_Menu_Locator = By.cssSelector("a[title='View my shopping cart']");
By Cart_Menu_X_Button = By.cssSelector("dl[class='products']>dt>span>a");


    //Method to delete 4 item when there is 4 product in the cart
    //not valid wh
    public CartSummaryPage Delete_Fourth_Product_By_Value_QTY(){
        $(Quantity_TextBox_Fourth_Product_Locator).scrollIntoView(true).shouldBe(Condition.visible).setValue("0").pressEnter().shouldNot(Condition.exist);
               return this;
    }
    public CartSummaryPage Delete_Third_Product_By_Minus_Btn(){
        $(Minus_Button_Third_Product).scrollIntoView(true).shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
       return this;
    }
    public CartSummaryPage Delete_Second_Product_By_Bin_Btn(){
        $(Bin_Button_Second_Element).scrollIntoView(true).shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
        return this;
    }
    public CartSummaryPage Delete_Remaining_Product_By_Menu(){
                $(Cart_Menu_Locator).scrollIntoView(true).should(Condition.visible).hover();
                $(Cart_Menu_X_Button).exists();
                $(Cart_Menu_X_Button).isDisplayed();
                $(Cart_Menu_X_Button).click();
        return this;
    }
}
