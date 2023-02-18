package day04_jUnitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C06_assertions {
    String str1 ="Ali";
    String str2 = "ali";
    @Test
    public void test01(){
        Assert.assertEquals(str1,str2);
       // if(str1.equals(str2)) {
       //     System.out.println("esitlik testi passed");
       // }else System.out.println("esitlik testi failed");
    }
    @Test
    public void test02(){
        Assert.assertTrue(str1.contains("A"));
       // if(str1.contains("A")) System.out.println("olumlu test passed");
       // else System.out.println("olumlu test failed");
    }
    @Test
    public void test03(){
        Assert.assertFalse(str2.contains("C"));
       // if (!str2.contains("C")) System.out.println("negatif test passed");
       // else System.out.println("negatif test failed");
    }

}
