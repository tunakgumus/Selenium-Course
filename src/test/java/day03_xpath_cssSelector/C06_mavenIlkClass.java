package day03_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class C06_mavenIlkClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        String sonucSayisi = driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div")).getText();
        int sonuc = Integer.parseInt(sonucSayisi.substring(sonucSayisi.indexOf("of")+3,sonucSayisi.indexOf("results")-1));
        System.out.println(sonuc);
        //5- Ilk urunu tiklayalim
       WebElement ilkUrun = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
       ilkUrun.click();
        //6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();

        List<WebElement> baslikElementleriListesi =   driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        int baslikNo=1;
        for (WebElement eachElement: baslikElementleriListesi
        ) {
            System.out.println(baslikNo +" --- " + eachElement.getText());
            baslikNo++;
        }
        Thread.sleep(3000);
        driver.close();

    }
}
