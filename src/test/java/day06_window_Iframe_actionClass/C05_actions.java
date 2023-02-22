package day06_window_Iframe_actionClass;

import Utilities.TestBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Set;

public class C05_actions extends TestBase {
    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions action = new Actions(driver);
        WebElement stripedArea = driver.findElement(By.xpath("/html/body/div[2]/div/div/div"));
        action.contextClick(stripedArea).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlert = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(actualAlertYazisi,expectedAlert);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        String alertWH = driver.getWindowHandle();
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("/html/body/div[3]/div/div/a")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> whSet = driver.getWindowHandles();
        String elemantalWH="";
        for (String each:whSet
             ) {
            if (!each.equals(alertWH))elemantalWH=each;
        }
        driver.switchTo().window(elemantalWH);
        String expectedH1 = "Elemental Selenium";
        String expectedH12= driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedH1,expectedH12);
    }
    }

