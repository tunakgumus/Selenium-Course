package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CookiesGecme {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement googleAramaCubugu = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        googleAramaCubugu.sendKeys("Java");
        googleAramaCubugu.submit();

        String aramaSonucuStr = driver.findElement(By.xpath("/html/body/div[7]/div/div[7]/div[1]/div/div/div/div")).getText();
        int ilkBosluk = aramaSonucuStr.indexOf(" ");
        int ikinciBosluk = aramaSonucuStr.indexOf(" ",ilkBosluk+1);

        String aramaSonucu = aramaSonucuStr.substring(ilkBosluk+1,ikinciBosluk);
        aramaSonucu=aramaSonucu.replaceAll("\\D","");

        int aramaSonucuInt = Integer.parseInt(aramaSonucu);

        if (aramaSonucuInt>100000) System.out.println("Arama sonucu testi PASSED");
        else System.out.println("Arama testi sonucu FAILED");


        driver.close();
    }
}
