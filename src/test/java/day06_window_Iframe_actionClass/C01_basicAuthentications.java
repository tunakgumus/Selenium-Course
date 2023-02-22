package day06_window_Iframe_actionClass;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class C01_basicAuthentications extends TestBase {
    //1- Bir class olusturun : BasicAuthentication
    //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //Html komutu : https://username:password@URL
    // Username    : admin
    //  password     : admin
    //4- Basarili sekilde sayfaya girildigini dogrulayin

    @Test
    public void test1(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String actualYazi= driver.findElement(By.xpath("/html/body/div[2]/div/div/p     ")).getText();
        String istenenIfade="Congratulations";
        Assert.assertTrue(actualYazi.contains(istenenIfade));
        bekle(5);
    }
}
