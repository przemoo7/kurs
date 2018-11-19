package pozostałe;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FluentWaitTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dynamic_loading/1");
    }

    @Test
    public void fluentWaitTest() {
        WebElement finishtext = driver.findElement(By.cssSelector("#finish h4"));
        assertFalse(finishtext.isDisplayed());

        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(finishtext));


        assertTrue(finishtext.isDisplayed());




    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}