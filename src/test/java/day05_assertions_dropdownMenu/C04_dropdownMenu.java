package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_dropdownMenu {
    //● Bir class oluşturun: C3_DropDownAmazon
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //	-Test 2
    // 1. Kategori menusunden Books secenegini secin
    // 2. Arama kutusuna Java yazin ve aratin
    // 3. Bulunan sonuc sayisini yazdirin
    // 4. Sonucun Java kelimesini icerdigini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test1 (){
        WebElement ddm =driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[1]/div/div/select"));

        Select select =new Select(ddm);
        int actualOptionSayisi = select.getOptions().size();
        int expectedOptionSayisi= 45;
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
    }

    //	-Test 2
    // 1. Kategori menusunden Books secenegini secin
    // 2. Arama kutusuna Java yazin ve aratin
    // 3. Bulunan sonuc sayisini yazdirin
    // 4. Sonucun Java kelimesini icerdigini test edin
    @Test
    public void test2 () {
        WebElement ddm =driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[1]/div/div/select"));
        Select select =new Select(ddm);
        select.selectByVisibleText("Books");
        WebElement aramaKutusu = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        String sonucSayisi = driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        System.out.println(sonucSayisi);
        Assert.assertTrue(sonucSayisi.contains("Java"));
    }
}
