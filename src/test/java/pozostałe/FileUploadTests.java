package pozostałe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl:8095/upload");
    }

    @Test
    public void fileUploadTest() {
        WebElement uploadButton = driver.findElement(By.id("file-upload"));
        uploadButton.sendKeys("C:\\test.jpg");

        WebElement sendButton = driver.findElement(By.id("file-submit"));
        sendButton.click();

        WebElement uploadedeFiles = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedeFiles.getText(), "test.jpg");

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}