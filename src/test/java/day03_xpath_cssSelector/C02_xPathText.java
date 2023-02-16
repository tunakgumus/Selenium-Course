package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_xPathText {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
            driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        WebElement addElementButonu = driver.findElement(By.xpath("//*[text()='Add Element']"));
        addElementButonu.click();
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu =driver.findElement(By.xpath("//*[text()='Delete']"));

        if(deleteButonu.isDisplayed()){
            System.out.println("Delete buton testi PASSED");
            deleteButonu.click();
            WebElement addRemoveElementsButonu= driver.findElement(By.xpath("/html/body/div[2]/div/h3"));
            if(addRemoveElementsButonu.isDisplayed())System.out.println("Add/Remove Elements butonu testi PASSED");
            else System.out.println("Add/Remove Elements butonu testi FAILED");

        }else System.out.println("Delete butonu testi FAILED");


        //4- Delete tusuna basin
        //5-
        //
        // “Add/Remove Elements” yazisinin gorunur oldugunu test edin
    }
}

