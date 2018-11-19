package pozostałe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxestests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/checkboxes");
    }

    @Test
    public void checkboxesTest() {

        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement secondChceckbox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        assertFalse(firstCheckbox.isSelected());
        assertTrue(secondChceckbox.isSelected());

        firstCheckbox.click();
        secondChceckbox.click();

        assertTrue(firstCheckbox.isSelected());
        assertFalse(secondChceckbox.isSelected());


    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}