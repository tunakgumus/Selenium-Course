package day04_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ilkAssertion {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin

    static WebDriver driver ;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void close(){
        driver.close();
    }
    @Test
    public void test1(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin

        String actualUrl=driver.getCurrentUrl();
        String istenenUrl="https://www.bestbuy.com/";

        Assert.assertEquals(istenenUrl,actualUrl);
    }
    @Test
    public void test2(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitlr=driver.getTitle();
        String istenenIcerik="Rest";

        Assert.assertFalse(actualTitlr.contains("Rest"));
    }
    @Test
    public void test3(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/img"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisLink = driver.findElement(By.xpath("/html/body/div[1]/ul/li[2]/button"));
        Assert.assertTrue(francaisLink.isDisplayed());

    }








}
