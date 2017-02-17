

import PageObject.IndexPage;
import PageObject.NewsFeed;
import com.codeborne.selenide.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by alex on 1/26/2017.
 */
public class LoginTest {

@BeforeClass
public static void setUp(){
  System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
   System.setProperty("selenide.browser", "gecko");
}

    @Before
    public void tearDown(){
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.getAndCheckWebDriver().manage().deleteAllCookies();
    }

    @Test
public void canLoginTest(){

IndexPage page = new IndexPage();
        NewsFeed feed = page.openEmailLogin().login(IndexPage.login, IndexPage.password);
        feed.yourFeedIsEmpty().shouldBe(Condition.visible);
}

    @Test
    public void canLoginWithWrongEmail(){

        IndexPage page = new IndexPage();
        page.openEmailLogin().login(IndexPage.login + "m", IndexPage.password);
        assertTrue(page.loginErrorIsPresent());

    }

    @Test
    public void canLoginWithWrongPassword(){

        IndexPage page = new IndexPage();
        page.openEmailLogin().login(IndexPage.login, IndexPage.password + "0");
        assertTrue(page.loginErrorIsPresent());


    }


    //And so on...


}


