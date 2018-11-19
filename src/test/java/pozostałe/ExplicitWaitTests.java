package pozostałe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExplicitWaitTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/dynamic_controls");
    }

    @Test
    public void waitForPresenceOfTheElement() {
     WebElement checkbox = driver.findElement(By.id("checkbox"));

     assertTrue(checkbox.isDisplayed());
     assertFalse(checkbox.isSelected());

     WebElement removeOrAddButton = driver.findElement(By.id("btn"));
     removeOrAddButton.click();

        WaitUntil waitUntil = new WaitUntil(driver);
        waitUntil.waitUntilElementIsInvisible(checkbox);

        WebElement textMessage = driver.findElement(By.id("message"));
        assertTrue(textMessage.isDisplayed());

        removeOrAddButton.click();

        checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}