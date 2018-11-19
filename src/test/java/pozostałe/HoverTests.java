package pozostałe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HoverTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/hovers");
    }

    @Test
    public void hoverTest() {
        WebElement firstAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        WebElement secondAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[2]"));
        WebElement thirdAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[3]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstAvatar).perform();

        WebElement firstAvatarCaption = driver.findElement(By.xpath("//div[1]/div/h5"));
        WebElement secondAvatarCaption = driver.findElement(By.xpath("//div[2]/div/h5"));
        WebElement thirdAvatarCaption = driver.findElement(By.xpath("//div[3]/div/h5"));

        assertEquals(firstAvatarCaption.getText(),"name: user1");
        assertEquals(secondAvatarCaption.getText(),"");
        assertEquals(thirdAvatarCaption.getText(), "");

        actions.moveToElement(secondAvatar).perform();

        assertEquals(firstAvatarCaption.getText(), "");
        assertEquals(secondAvatarCaption.getText(), "name: user2");
        assertEquals(thirdAvatarCaption.getText(), "");

        actions.moveToElement(thirdAvatar).perform();

        assertEquals(firstAvatarCaption.getText(), "");
        assertEquals(secondAvatarCaption.getText(), "");
        assertEquals(thirdAvatarCaption.getText(),"name: user3");

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}