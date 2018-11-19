package pozostałe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Test81 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://10.30.34.16:9080/Pobyt2/login.html?forwardto=POBYT2");
    }
    @Test
    public void loginTest(){
        sleep();
        WebElement userNameField = driver.findElement(By.xpath("//*[@id=\"isc_K\"]"));
        userNameField.sendKeys("d");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"isc_N\"]"));
        passwordField.sendKeys("d");

        WebElement loginClick = driver.findElement(By.xpath("//*[@id=\"isc_R\"]"));
        loginClick.click();
        sleep();

        WebElement anotherClick = driver.findElement(By.xpath("//*[@id=\"isc_H\"]"));
        anotherClick.click();
        sleep();
        WebElement wylogujClick = driver.findElement(By.xpath("//*[@id=\"isc_1G\"]"));
        System.out.println("Is wylogujClick displayed: " + wylogujClick.isDisplayed());
        System.out.println("Is wylogujClick enabled: " + wylogujClick.isEnabled());

        assertTrue(wylogujClick.isEnabled());
        sleep();

        WebElement wniosekButton = driver.findElement(By.id("isc_1P"));
        WebElement azylWRPButton = driver.findElement(By.id("isc_2U"));
        WebElement dodajNowyWniosekButton = driver.findElement(By.id("isc_2Y"));

        Actions action = new Actions(driver);

        action.moveToElement(wniosekButton).moveToElement(azylWRPButton).moveToElement(dodajNowyWniosekButton).build().perform();

        WebElement addPersonButton = driver.findElement(By.id("isc_5M"));
        addPersonButton.click();

        WebElement CalendarField = driver.findElement(By.xpath("//*[@id=\"isc_R\"]"));
        CalendarField.click();
        CalendarField.sendKeys("20171010");
        sleep();


    }
    private void sleep() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}