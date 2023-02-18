package day04_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_zeroTest {
    @Test
    public void test01(){
        //1. http://zero.webappsecurity.com sayfasina gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        WebElement signinButonu = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/ul/li[2]/button"));
        signinButonu.click();
        //3. Login alanine  “username” yazdirin
        WebElement loginAlani = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/form/div[1]/div[1]/div/input"));
        loginAlani.sendKeys("username");
        //4. Password alanine “password” yazdirin
        WebElement passwordAlani = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/form/div[1]/div[2]/div/input"));
        passwordAlani.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        WebElement signinSubmit = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/form/div[2]/input"));
        signinSubmit.submit();
        driver.navigate().back();
        //6. online banking altindaki Pay Bills sayfasina gidin
        WebElement onlineBanking = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/ul/li[2]/div/strong"));
        onlineBanking.click();

        driver.findElement(By.id("pay_bills_link")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("100");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        String sonucYazisi= driver.findElement
                        (By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/div/span"))
                        .getText();
        if(sonucYazisi.equals("The payment was successfully submitted.")) System.out.println("Test : PASSED");
        else System.out.println("Test : FAILED");
    }
}
