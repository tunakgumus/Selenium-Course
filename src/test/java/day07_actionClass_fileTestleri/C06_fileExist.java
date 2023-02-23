package day07_actionClass_fileTestleri;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_fileExist extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("/html/body/div[2]/div/div/a[2]")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\tuna_\\Downloads\\logo.png";
        boolean sonuc = Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);
    }
}
