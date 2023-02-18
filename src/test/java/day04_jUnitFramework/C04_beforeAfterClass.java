package day04_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_beforeAfterClass {
    //// 3 test method'u olusturun
    //// 1.amazon anasayfaya gidip, amazona gittiginizi test edin
    //// 2.Nutella aratip arama sonuclarinin nutella icerdigini test edin
    //// 3.Ilk urune tiklayip, urun isminde Nutella gectigini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        // 1.amazon anasayfaya gidip, amazona gittiginizi test edin
        driver.get("https://www.amazon.com");

        String expectedIcerik= "amazon";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Amazon testi PASSED");
        }else{
            System.out.println("Url amazon icermiyor, test FAILED");
        }
    }

    @Test
    public void test02(){
        // 2.Nutella aratip arama sonuclarinin nutella icerdigini test edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement aramaSonucElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik= "Nutella";
        String actualSonucYazisi= aramaSonucElementi.getText();

        if (actualSonucYazisi.contains(expectedIcerik)){
            System.out.println("Nutella testi PASSED");
        }else {
            System.out.println("Nutella testi FAILED");
        }
    }

    @Test @Ignore
    public void test03(){
        // 3.Ilk urune tiklayip, urun isminde Nutella gectigini test edin
        WebElement ilkUrun= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        ilkUrun.click();

        WebElement urunIsimElementi= driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIcerik= "Nutella";
        String actualUrunIsmi= urunIsimElementi.getText();

        if (actualUrunIsmi.contains(expectedIcerik)){
            System.out.println("ilk urun testi PASSED");
        }else{
            System.out.println("Ilk urun testi FAILED");
        }



    }
}



