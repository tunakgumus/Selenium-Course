package day07_actionClass_fileTestleri;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C02_keyboardActions extends TestBase {
    @Test
    public void test01(){
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com ");
        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).click();
        Actions action =new Actions(driver);
        action.keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71"+Keys.ENTER).perform();
        bekle(6);

        //4- aramanin gerceklestigini test edin
        String searchResult =driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        String expectedInput= "Samsung A71";

        Assert.assertTrue(searchResult.contains(expectedInput));
    }
}
