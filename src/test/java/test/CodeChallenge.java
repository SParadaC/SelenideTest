package test;

import Pages.CartSummaryPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultPage;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@Listeners(UniversalVideoListener.class)

public class CodeChallenge {
    HomePage Automation = new HomePage();
    SearchResultPage Search = new SearchResultPage();
    ProductPage Product = new ProductPage();
    CartSummaryPage Summary = new CartSummaryPage();


    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "http://automationpractice.com/";
        Selenide.open("/");
        getWebDriver().manage().window().maximize();
    }
    @Test(groups = "Exercise 1")
    public void Add_Product_From_List() throws InterruptedException {
        Automation.Search_For_Valid_Product();
        Search.Select_List();
        Thread.sleep(3000);
        Search.Results_By_List();

    }


    @Test(groups = "Exercise 1")
    @Video(name = "Test")
    public void Add_Product_From_Main() throws InterruptedException {
        Automation.Selected_Product_From_Homepage();
        Product.Send_Value_of_Quantity();
        Product.Reduce_Quantity_By_Button();
        Product.Select_Size();
        Product.Color_Option();
        Thread.sleep(5000);
        Product.Add_to_Cart();
        Product.Layer_Cart_Proceed_to_Checkout();
        Thread.sleep(5000);
        //Selenide.$("#cart_title").should(Condition.exist).shouldNotBe(Condition.visible);
        Thread.sleep(5000);
        System.out.println(Selenide.title());
        //Assert.assertEquals(Selenide.title(), "Order - My Store");

    }

    @Test(groups = "Exercise 2")
    public void Delete_Products_Scenarios() throws InterruptedException {
        Automation.Search_For_Valid_Product();
        Search.Select_Grid();
        Thread.sleep(1000);
        Search.Valid_Search_Result();
        Thread.sleep(2000);
        Search.Results_Founds();
        Thread.sleep(1000);
        Summary.Delete_Fourth_Product_By_Value_QTY();
        Thread.sleep(1000);
        Summary.Delete_Third_Product_By_Minus_Btn();
        Thread.sleep(1000);
        Summary.Delete_Second_Product_By_Bin_Btn();
        Thread.sleep(3000);
        Summary.Delete_Remaining_Product_By_Menu();
        Thread.sleep(5000);
    }


    @Test(groups = "Exercise 3")
    public void Search_Result_Valid() {
        Automation.Search_For_Valid_Product();
        Search.Valid_Search_Result();
    }

    @Test(groups = "Exercise 3")
    public void Search_Result_Invalid() {
        Automation.Search_For_Invalid_Product();
        Search.Invalid_Search_Result();
    }

    @Test(groups = "Exercise 3")
    public void StoreInformation() {

        Automation.find_Store_Information();
        Automation.Get_Store_Information();

    }

    @AfterClass
    public static void afterClass() {
        Selenide.closeWebDriver();
    }

}

