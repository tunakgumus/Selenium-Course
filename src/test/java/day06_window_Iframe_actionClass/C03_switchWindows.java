package day06_window_Iframe_actionClass;

import Utilities.TestBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class C03_switchWindows extends TestBase {
    @Test
    public void test01 (){
    // amazon anasayfaya gidip, arama kutusunun erisilebilir oldugunu test edin
    driver.get("https://amazon.com");
        Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isEnabled());
        String amazonWindowHandle = driver.getWindowHandle();
    // yeni bir tab olarak wisequarter.com'a gidin
    // url'in wisequarter icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");
        String actualUrl = driver.getCurrentUrl();
        String beklenenIcerik = "wisequarter";
        Assert.assertTrue(actualUrl.contains(beklenenIcerik));
        String wiseWindowHandle = driver.getWindowHandle();

    // amazon'un acik oldugu tab'a geri donup
    // Nutella icin arama yapin
    // Sonuclarin Nutella icerdigini test edin
        driver.switchTo().window(amazonWindowHandle);
        WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);
        bekle(5);
        String actualSonucYazisi = driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        String istenenIcerik = "Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(istenenIcerik));
    // yeni bir window olarak youtube.com'a gidin
    // Url'in youtube icerdigini test edin
       driver.switchTo().newWindow(WindowType.WINDOW);
       driver.get("https://youtube.com");
       String gecerliUrl= driver.getCurrentUrl();
       String istenenIcerik2 = "youtube";
       Assert.assertTrue(gecerliUrl.contains(istenenIcerik2));
        // wisequarter'in acik oldugu sayfaya donun
    // Title'in WiseQuarter icerdigini test edin
        driver.switchTo().window(wiseWindowHandle);
        String wiseTitle = driver.getTitle();
        String beklenenTitle = "Wise Quarter";
        Assert.assertTrue(wiseTitle.contains(beklenenTitle));
    }
}
