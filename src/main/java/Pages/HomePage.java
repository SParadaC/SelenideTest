package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    public HomePage open(){
        Selenide.open("/");
        return this;
    }

    public HomePage find_Store_Information(){
        $(By.xpath("//section[@id='block_contact_infos']/div/ul/li")).scrollIntoView(true);
        return this;
    }

    //Condition matchText was not the best option since it require
    public HomePage Get_Store_Information(){
        ElementsCollection Information = $$(By.xpath("//section[@id='block_contact_infos']/div/ul/li"));
        System.out.println(Information.get(0).should(Condition.text("Selenium Framework, Research Triangle Park, North Carolina, USA")));
        System.out.println(Information.get(1).shouldBe(Condition.matchText("Call us now: (347) 466-7432")));
        System.out.println(Information.get(2).shouldHave(Condition.exactText("Email: support@seleniumframework.com")));
        return this;
    }
}
