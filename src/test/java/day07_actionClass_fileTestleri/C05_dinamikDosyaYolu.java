package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_dinamikDosyaYolu {
    @Test
    public void test01 (){
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/Thedelta.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
