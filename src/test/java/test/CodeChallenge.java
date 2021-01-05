package test;

import Pages.HomePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CodeChallenge {
    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "http://automationpractice.com/";
    }

    @Test
    public void userCanSearch() {
        HomePage Automation = new HomePage();
        Automation.open();
        Automation.find_Store_Information();
        Automation.Get_Store_Information();

    }
    @AfterClass
    public static void afterClass(){
        Selenide.closeWebDriver();
    }

}

