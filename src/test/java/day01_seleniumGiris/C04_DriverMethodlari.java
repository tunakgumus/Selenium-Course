package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wisequarter.com");
        System.out.println(driver.getWindowHandle());

        System.out.println(driver.getPageSource());

        String expectedIcerik = "elementor-widget-wrap";
        String actualSayfaKodlari = driver.getPageSource();

        if(actualSayfaKodlari.contains(expectedIcerik)) System.out.println("Test : PASSED");
        else System.out.println("Test : FAILED");

        driver.quit();
    }
}
