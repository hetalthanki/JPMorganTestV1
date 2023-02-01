package hooks;


import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private DriverFactory driverFactory;
    private ConfigReader configReader;
    Properties prop;
    private WebDriver driver;

    @Before(order = 0)
    public void getProperty()
    {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        System.out.println("prop object returned");
    }

    @Before(order = 1)
    public void launchBrowser()
    {
        String browserName = prop.getProperty("browser");
        System.out.println("browsername in launch browser:"+browserName);
        driverFactory = new DriverFactory();
        driver = driverFactory.init_browser(browserName);
    }

    @After(order = 0)
    public void quitBrowser()
    {
        driver.quit();
    }

    //take screenshots when scenario fails
    @After(order = 1)
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            String screenShotName = scenario.getName().replaceAll(" ", "_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenShotName);
        }
    }
}

