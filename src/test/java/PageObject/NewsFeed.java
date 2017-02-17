package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by alex on 2/17/2017.
 */
public class NewsFeed {

    public static final String yourFeedIsEmpty = "body > div.view-container.clearfix > div > p";



    public SelenideElement yourFeedIsEmpty(){

        return $(yourFeedIsEmpty);
    }







}
