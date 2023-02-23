package day07_actionClass_fileTestleri;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_filePath {
    @Test
    public void test01(){
        String dosyaYolu = "C:\\Users\\tuna_\\OneDrive\\Masaüstü\\TheDelta.docx";



        //System.out.println(System.getProperty("user.home"));
        //dosyaYolu = System.getProperty("user.home")+ "/Downloads/bedia%20buse%20can%20912%20teklifi.pdf";
        boolean sonuc = Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);


    }
}
