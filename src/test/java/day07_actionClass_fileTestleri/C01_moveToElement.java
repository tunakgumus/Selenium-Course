package day07_actionClass_fileTestleri;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_moveToElement extends TestBase {
    @Test
    public void test01 () {
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions action = new Actions(driver);
        WebElement accountList = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]/span"));
        action.moveToElement(accountList).perform();
        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div[3]/div[2]/div/div[2]/a[1]/span")).click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourList = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/ul/li[1]/a/div"));
        Assert.assertTrue(yourList.isDisplayed());
    }
}
