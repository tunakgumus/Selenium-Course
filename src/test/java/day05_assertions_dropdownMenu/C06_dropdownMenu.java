package day05_assertions_dropdownMenu;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C06_dropdownMenu extends TestBase {
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın.

    @Test
    public void test1 (){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm = driver.findElement(By.id("dropdown"));
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Select select =new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddmElements = select.getOptions();
        for (WebElement each:ddmElements
             ) {
            System.out.println(each.getText());
        }
        // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın.
        int ddmBoyut = select.getOptions().size();
        if(ddmBoyut==4) System.out.println("True");else System.out.println("False");
        bekle(5);
    }

}
