package day05_assertions_dropdownMenu;

import Utilities.TestBaseClasses;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C07_JsAlert extends TestBaseClasses {
    // Ilgili method'lari kullanin
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 1.alert'e tiklayalim
    // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
    // OK tusuna basip alert'i kapatalim
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/button")).click();

        String actualIcerik = driver.switchTo().alert().getText();
        String beklenenIcerik = "I am a JS Alert";
        Assert.assertEquals(beklenenIcerik, actualIcerik);
        driver.switchTo().alert().accept();
    }

    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 2.alert'e tiklayalim
    // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
    @Test
    public void test2() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button")).click();

        driver.switchTo().alert().dismiss();
        String result = driver.findElement(By.id("result")).getText();
        String beklenenIcerik = "You clicked: Cancel";
        Assert.assertEquals(beklenenIcerik, result);
    }

    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3.alert'e tiklayalim
    // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
    // Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void test3() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/button")).click();

        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        String beklenenIcerik = "Abdullah";

        Assert.assertTrue(result.contains(beklenenIcerik));
        driver.switchTo().alert().accept();
    }
}