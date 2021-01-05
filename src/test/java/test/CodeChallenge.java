package test;

import Pages.HomePage;
import Pages.SearchResultPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CodeChallenge {
    HomePage Automation = new HomePage();
    SearchResultPage Search = new SearchResultPage();

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "http://automationpractice.com/";
        Selenide.open("/");
        getWebDriver().manage().window().maximize();
    }
   @Test
    public void Add_Product_From_Main() {
       Automation.Selected_Product_From_Homepage();
   }
    @Test
    public void Search_Result_Valid(){
        Automation.Search_For_Valid_Product();
        Search.Valid_Search_Result();
    }

    @Test
    public void Search_Result_Invalid(){
        Automation.Search_For_Invalid_Product();
        Search.Invalid_Search_Result();
    }

    @Test
    public void StoreInformation() {

        Automation.find_Store_Information();
        Automation.Get_Store_Information();

    }
    @AfterClass
    public static void afterClass(){
                Selenide.closeWebDriver();
    }

}

