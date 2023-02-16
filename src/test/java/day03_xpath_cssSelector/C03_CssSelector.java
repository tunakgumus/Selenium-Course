package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_CssSelector {
    public static void main(String[] args) {
        //1- bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String sayfaBasligi = driver.getTitle();
        if(sayfaBasligi.contains("Spend less")) System.out.println("Baslik testi PASSED");
        else System.out.println("Baslik Testi FAILED");
        //6- Gift Cards sekmesine basin
        WebElement giftCardsButonu = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[4]"));
        giftCardsButonu.click();
        //7- Birthday butonuna basin
        WebElement birthdayButonu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[2]/div/div/a/img"));
        birthdayButonu.click();
        //8- Best Seller bolumunden ilk urunu tiklayin
        WebElement bestSellerIlkUrunButonu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/ol/li[1]/div/a/span/span[2]"));
        bestSellerIlkUrunButonu.click();
        //9- Gift card details’den 25 $’i secin
        WebElement giftCardDetails25$ = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[4]/div[4]/form/div[7]/div/div[2]/span/span/ul/li[1]/span/span/span/button"));
        giftCardDetails25$.click();
        //10-Urun ucretinin 25$ oldugunu test edin
        WebElement ucretAlani = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div/p/span"));
        String expectedUcret="25$";
        String actualUcret= ucretAlani.getText();

        if(ucretAlani.equals(actualUcret)) System.out.println("Ucret Testi PASSED");
        else System.out.println("Ucret testi FAILED");
        System.out.println("Actual Ucret : " + actualUcret);
        //11-Sayfayi kapatin
        driver.close();
    }
}
