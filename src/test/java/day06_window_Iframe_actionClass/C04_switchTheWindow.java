package day06_window_Iframe_actionClass;

import Utilities.TestBaseClasses;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class C04_switchTheWindow extends TestBaseClasses {
    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // ● Click Here butonuna basın.
    // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String text = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();
        String beklenenText ="Opening a new window";

        Assert.assertEquals(text,beklenenText);


        String title = driver.getTitle();
        String expectedTitle= "The Internet";

        Assert.assertEquals(title,expectedTitle);
        String theInternetWindowHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("/html/body/div[2]/div/div/a")).click();

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        Set<String> allPagesWHs = driver.getWindowHandles();
        String  newWindowWH="";

        for (String each:allPagesWHs
             ) {
            if(!each.equals(theInternetWindowHandle)){
                newWindowWH=each;
            }
        }
        driver.switchTo().window(newWindowWH);
        String newTitle = driver.getTitle();
        String expectedNewTitle = "New Window";

        Assert.assertEquals(expectedNewTitle,newTitle);

        String pagetext = driver.findElement(By.xpath("/html/body/div/h3")).getText();
        String expectedPagetext = "New Window";

        Assert.assertEquals(pagetext,expectedPagetext);

        driver.switchTo().window(theInternetWindowHandle);
        bekle(5);
    }
}
