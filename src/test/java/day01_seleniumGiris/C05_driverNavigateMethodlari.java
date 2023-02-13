package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_driverNavigateMethodlari {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        driver.get("https://wisequarter.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to("https://youtube.com/");
        driver.navigate().refresh();
    }
}
