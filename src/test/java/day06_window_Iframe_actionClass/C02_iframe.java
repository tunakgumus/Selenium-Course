package day06_window_Iframe_actionClass;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_iframe extends TestBase {
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frameElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);
        WebElement yaziElementi = driver.findElement(By.tagName("p"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        driver.switchTo().defaultContent();
    }
}
