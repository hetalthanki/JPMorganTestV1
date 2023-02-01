package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class LogoPage {
    private WebDriver driver;

    //1. Locators
    private By txtGoogleSearchBox = By.name("q");
    private By imgLogo = By.xpath("//div[@class='logo-desktop-only']//img[@alt='J.P. Morgan logo']");
    private By acceptCookies = By.id("L2AGLb");
    private By allLinks = By.xpath("//div[@id='search']//a");
    private By btnGoogleSearch = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']");

    //2. constructor
    public LogoPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //3. Page Actions

    public String enterSearchTerm(String searchTerm)
    {
        driver.findElement(txtGoogleSearchBox).sendKeys(searchTerm);
        String enteredSearchTerm = driver.findElement(txtGoogleSearchBox).getText();
        return enteredSearchTerm;
    }

    public void clickEnterKey()
    {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).build().perform();
    }

    public void handleCookies()
    {
        //Handling cookies
        driver.findElement(acceptCookies).click();
    }

    public void clickFirstLink()
    {
        //Fatch all links from google search result page
        List<WebElement> list = driver.findElements(allLinks);
        for(WebElement e:list)
        {
            System.out.println(e.getText());

        }
        //clicks on first link
        list.get(0).click();
    }

    public boolean logoPresenceCheck() {
        boolean status = driver.findElement(imgLogo).isDisplayed();
        return status;
    }

    public void clickGoogleSearchbtn() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(btnGoogleSearch).click();
    }

}

