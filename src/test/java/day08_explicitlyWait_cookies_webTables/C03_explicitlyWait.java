package day08_explicitlyWait_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.TestBaseClasses.driver;

public class C03_explicitlyWait {
    @Test
    public void test01 (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/input"));
        Assert.assertFalse(textbox.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(40));
        enableBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(enableBox));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        String itEnabled = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/p")).getText();
        String expected = "It’s enabled!";
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textbox.isEnabled());
        driver.close();
    }
}
