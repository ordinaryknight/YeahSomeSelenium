package PageObject;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;


import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by alex on 1/28/2017.
 */
public class IndexPage {

    public static final String login = "myasko@mailinator.com";
    public static final String password = "123123";

    public static final String baseUrl = "https://news360.com/";

    public static final String companyField = "body > div.lining > div.header > div > div.bNav > a.eNav.startreading.ng-binding";
    public static final String dateField = "body > div.simplepopup > div.bHSignIn > div.socauth > div.eHSignIn_text.mBottom";
    public static final String loginField = "body > div.simplepopup.expand > div.bHSignIn > div.simpleauth > form.signin.ng-pristine.ng-valid > fieldset:nth-child(1) > input";
    public static final String passwordField = "body > div.simplepopup.expand > div.bHSignIn > div.simpleauth > form.signin.ng-pristine.ng-valid > fieldset:nth-child(2) > input";
    public static final String loginButton = "body > div.simplepopup.expand > div.bHSignIn > div.simpleauth > form.signin.ng-pristine.ng-valid > div.buttons > button.green-button.ladda-button.signin-button.ng-binding";
    public static final String loginPasswordErrorBox = "body > div.simplepopup.expand > div.bHSignIn > div.error-message.message.ng-binding";


    public IndexPage openEmailLogin(){

        open(baseUrl, IndexPage.class);
        $(companyField).click();
        $(dateField).click();

        return this;
    }

    public NewsFeed login(String login, String password){
        $(loginField).sendKeys(login);
        $(passwordField).sendKeys(password);
        $(loginButton).click();
        return page(NewsFeed.class);
    }

    public IndexPage refresh(){
        return this;
    }

    public boolean collectError(String errorMessage){ return $(byText(errorMessage)).is(Condition.visible); }

    public boolean loginErrorIsPresent(){ sleep(4000); return $(loginPasswordErrorBox).is(Condition.visible); }



}
