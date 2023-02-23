package day08_explicitlyWait_cookies_webTables;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class C05_WebTables extends TestBase {
    @Test
    public void test01(){
       //1.“https://www.amazon.com” adresine gidin
        driver.get("https://amazon.com");
        //2.Sayfanin en altina inin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin
        WebElement allBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(allBody.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satirlarListesi.size());

        //5.Tum satirlari yazdirin
        int sayi=1;
        for (WebElement each: satirlarListesi
             ) {
            System.out.println(sayi+"= "+each.getText());
            sayi++;
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
         List<WebElement> ucuncuSatirDatalarList = driver.findElements(By.xpath("/html/body/div[1]/div[5]/div[4]/table/tbody/tr[5]/td"));
        Assert.assertEquals(13,ucuncuSatirDatalarList.size());
        //7. 5.sutunu yazdirin
        List<WebElement> besinciSutunList = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        Assert.assertEquals(5,besinciSutunList.size());
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        WebElement sekizinciSatirSutun = driver.findElement(By.xpath("//tbody/tr[3]/td[5]"));
        System.out.println(sekizinciSatirSutun.getText());
    }
}
