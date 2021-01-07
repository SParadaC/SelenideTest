package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage {
    By Quantity_TextBox_Locator = By.cssSelector("#quantity_wanted");
    By Minus_Quantity_BTN_Locator = By.cssSelector(".icon-minus");
    By Plus_Quantity_BTN_Locator = By.cssSelector(".icon-plus");
    By Size_DropDown_Locator = By.cssSelector("#group_1");
    By Color_Options_Locator = By.cssSelector("#color_to_pick_list>li>a");
    By Add_To_Cart_Btn_Locator = By.cssSelector("button[class='exclusive']");
    By Continue_Shopping_Btn_Locator = By.cssSelector("[title='Continue shopping']");
    By Proceed_To_CheckOut_Btn_Locator = By.cssSelector("[title='Proceed to checkout']");

    public ProductPage Send_Value_of_Quantity(){
        $(Quantity_TextBox_Locator).clear();
        $(Quantity_TextBox_Locator).sendKeys("5");
        System.out.println("Quantity of place order: " + $(Quantity_TextBox_Locator).getValue());
        return this;
    }

    public ProductPage Reduce_Quantity_By_Button(){
        $(Minus_Quantity_BTN_Locator).doubleClick();
        System.out.println("Quantity of place order: " + $(Quantity_TextBox_Locator).getValue());
        return this;
    }
    public ProductPage Increase_Quantity_By_Button(){
        $(Plus_Quantity_BTN_Locator).doubleClick();
        System.out.println($(Quantity_TextBox_Locator).getValue());
        return this;
    }
    public ProductPage Select_Size(){
        System.out.println("Preselected size: " + $(Size_DropDown_Locator).getSelectedText());
        $(Size_DropDown_Locator).selectOptionContainingText("M");
        System.out.println("Selected sizes: " + $(Size_DropDown_Locator).getSelectedText());
        return this;
    }
    public ProductPage Color_Option()  {
        ElementsCollection colors = $$(Color_Options_Locator);
        System.out.println("Amount of available colors: " + colors.size());
        for (int i=0; i<colors.size(); i++
             ) {
            System.out.println("Available colors: " + colors.get(i).getAttribute("name"));
        }

        colors.get(0).click();
        return this;
    }
    public ProductPage Add_to_Cart(){
        $(Add_To_Cart_Btn_Locator).click();
        return this;
    }

    public ProductPage Layer_Cart_Continue_Shopping(){
        $(Continue_Shopping_Btn_Locator).isDisplayed();
        $(Continue_Shopping_Btn_Locator).click();
        return this;
    }
    public ProductPage Layer_Cart_Proceed_to_Checkout(){
        $(Proceed_To_CheckOut_Btn_Locator).isDisplayed();
        $(Proceed_To_CheckOut_Btn_Locator).click();
        return this;
    }
}
