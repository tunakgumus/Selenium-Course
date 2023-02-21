package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_assertions {
   //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");

    }
    @AfterClass
    public static void teardown (){
        driver.close();
    }
    //    3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTest(){
        String actualTitle =driver.getTitle();
        String beklenenTitle = "YouTube";
        Assert.assertEquals(beklenenTitle,actualTitle);
    }
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void logoTest(){
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[1]/ytd-topbar-logo-renderer/a/div/ytd-logo/yt-icon")).isDisplayed());
    }
    //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void searchBox(){
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")).isEnabled());
    }
    //    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void baslikTesti() {
        String actualTitle = driver.getTitle();
        String beklenenTitle = "youtube";
        Assert.assertNotEquals(beklenenTitle, actualTitle);
    }
}
