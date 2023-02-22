package day06_window_Iframe_actionClass;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_dragAndDrop extends TestBase {
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[1]"));
        WebElement dropHere= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragMe,dropHere).perform();
        bekle(20);
        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDropped = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/p")).getText();
        String expectedDropped = "Dropped!";

        Assert.assertEquals(actualDropped,expectedDropped);
    }
}
