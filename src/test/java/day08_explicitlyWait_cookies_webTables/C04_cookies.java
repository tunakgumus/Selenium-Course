package day08_explicitlyWait_cookies_webTables;

import Utilities.TestBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class C04_cookies extends TestBase {
    @Test
    public void test01(){
        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        //2- tum cookie’leri listeleyin
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        //8- tum cookie’leri silin ve silindigini test edin
        driver.get("https://amazon.com");
        Set<Cookie> cookiesSeti = driver.manage().getCookies();
        int siraNo=1;
        for (Cookie each:cookiesSeti
             ) {
            System.out.println(siraNo+": "+each);
            siraNo++;
        }
        System.out.println("===========================================");
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        Assert.assertTrue(siraNo>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String cookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedValue = "USD";
        Assert.assertEquals(cookieValue,expectedValue);
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie benimCookie =new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(benimCookie);
        cookiesSeti = driver.manage().getCookies();
        siraNo=1;
        for (Cookie each:cookiesSeti
        ) {
            System.out.println(siraNo+": "+each);
            siraNo++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        String actualValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        String expectedGetValue = "cikolatali";
        Assert.assertEquals(actualValue,expectedGetValue);
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookiesSeti=driver.manage().getCookies();
        for (Cookie each:cookiesSeti
        ) {
            Assert.assertFalse(each.getName().equals("skin"));
            }
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSeti = driver.manage().getCookies();
        Assert.assertTrue(cookiesSeti.size()==0);
        }


    }
