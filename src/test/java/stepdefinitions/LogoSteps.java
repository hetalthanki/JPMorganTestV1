package stepdefinitions;

import org.junit.Assert;

import com.pages.LogoPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LogoSteps {

    private LogoPage logopage = new LogoPage(DriverFactory.getDriver());

    //User press enter key for searching search term
    @Given("user opens google url {string}")
    public void user_opens_google_url(String url) {
        System.out.println("url of the google page:"+url);
        DriverFactory.getDriver().get(url);
        logopage.handleCookies();
    }

    @When("user enters search item {string}")
    public void user_enters_search_item(String searchTerm) {
        System.out.println("search term:"+searchTerm);
        String enteredSearchTerm = logopage.enterSearchTerm(searchTerm);
       // Assert.assertEquals(searchTerm, enteredSearchTerm);
    }

    @When("User clicks enter key")
    public void user_clicks_enter_key() {
        logopage.clickEnterKey();
    }

    @When("click on first link of google result page")
    public void click_on_first_link_of_google_result_page() {
        logopage.clickFirstLink();
    }


    @Then("The logo should be present on Home page")
    public void the_logo_should_be_present_on_home_page() {
        boolean status = logopage.logoPresenceCheck();
        Assert.assertEquals(true,status);
    }


    //user clicks on google search button
    @When("user clicks on google search button")
    public void user_clicks_on_google_search_button() throws InterruptedException {
            logopage.clickGoogleSearchbtn();
    }
}
