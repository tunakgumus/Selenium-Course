package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_relativeLocators {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html\n");

        WebElement berlinElementi = driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[7]/a/img"));
        WebElement nycElementi = driver.findElement(By.xpath("/html/body/div/div[2]/ul/li[3]/a/img"));
        WebElement bostonElementi = driver.findElement(By.xpath("//*[@*='pid6_thumb']"));
        WebElement sailorElementi = driver.findElement(By.xpath("//*[@*='pid11_thumb']"));

        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(nycElementi));
        System.out.println(berlin1.getAttribute("id"));

        WebElement berlin2 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElementi));
        System.out.println(berlin1.getAttribute("id"));

        driver.close();
    }
}
