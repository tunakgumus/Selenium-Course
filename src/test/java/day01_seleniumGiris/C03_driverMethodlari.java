package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_driverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        System.out.println("URL : "+ driver.getCurrentUrl());
        System.out.println("Baslik : " + driver.getTitle());



        String expectedIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();



        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        driver.quit();

    }
}
