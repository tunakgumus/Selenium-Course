package day08_explicitlyWait_cookies_webTables;

import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.TestBaseClasses.driver;

public class C02_explicitlyWait{
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://amazon.com");

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(40));
        // WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable())
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));

        searchBox.sendKeys("Nutella" + Keys.ENTER);
        driver.close();
}
}