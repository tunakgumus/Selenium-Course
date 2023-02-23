package day07_actionClass_fileTestleri;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C07_fileUploadTesti extends TestBase {
    @Test
    public void test01 (){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim
        String filePath = "C:\\Users\\tuna_\\OneDrive\\Masaüstü\\TheDelta.docx";
        WebElement upload = driver.findElement(By.id("file-submit"));
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys(filePath);
        upload.click();
        WebElement fileUploaded = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        Assert.assertTrue(fileUploaded.isDisplayed());
        //3.Yuklemek istediginiz dosyayi secelim.
        //4.Upload butonuna basalim.
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
    }
}
