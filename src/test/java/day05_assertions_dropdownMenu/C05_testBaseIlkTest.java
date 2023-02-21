package day05_assertions_dropdownMenu;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C05_testBaseIlkTest extends TestBase {
    @Test
    public void amazonTest(){
    driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String sonucSayisi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        System.out.println(sonucSayisi);
        String beklenenSonuc = "Nutella";
        Assert.assertTrue(sonucSayisi.contains(beklenenSonuc));
    }
}
