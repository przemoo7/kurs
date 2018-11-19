package pozostałe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class Test79 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.navigate().to("http://10.30.34.16:9080/Pobyt2/login.html?forwardto=POBYT2");
    }
    @Test
    public void loginTest(){

        WebElement userNameField = driver.findElement(By.xpath("//*[@id=\"isc_K\"]"));
        userNameField.sendKeys("d");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"isc_N\"]"));
        passwordField.sendKeys("d");

        WebElement loginClick = driver.findElement(By.xpath("//*[@id=\"isc_R\"]"));
        loginClick.click();

        WebElement anotherClick = driver.findElement(By.xpath("//*[@id=\"isc_H\"]"));
        anotherClick.click();

        WebElement wniosekField = driver.findElement(By.xpath("//*[@id=\"isc_1N\"]"));
        wniosekField.click();

        WebElement zaproszenieField = driver.findElement(By.xpath("//*[text()[contains(.,'Zaproszenie')]]"));
        zaproszenieField.click();


    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}