package day02_webelementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_findElements {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java");
        aramaKutusu.submit();

        List<WebElement> aramaSonuclariElementList = driver.findElements(By.className("sg-col-inner"));
        System.out.println(aramaSonuclariElementList.size());

        System.out.println(aramaSonuclariElementList);

        for (WebElement each:aramaSonuclariElementList
             ) {
            System.out.println(each.getText());
        }







        Thread.sleep(3000);
        driver.close();


    }
}
