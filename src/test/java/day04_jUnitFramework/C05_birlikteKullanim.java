package day04_jUnitFramework;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class C05_birlikteKullanim {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class calisti \n=============");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("===========\nAfter Class calsiti");
    }
    @Before
    public void before(){
        System.out.println("\nBefore method'u calisti");
    }
    @Test
    public void test01(){
        System.out.println("Test1 calisti");
    }
    @Test
    public void test02(){
        System.out.println("Test2 calisti");
    }
    @Test
    public void test03(){
        System.out.println("Test3 calisti");
    }

    }

