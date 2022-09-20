package practise;

import org.checkerframework.checker.units.qual.A;
import org.junit.*;

public class C02_JUnit {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
        // Her class ilk calisir. 1 kere calisir
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
        // Her class'da son calisir. 1 kere calisir
    }

    @Before
    public void before(){
        System.out.println("Before");
        // Her setten once calisir
    }

    @After
    public void after(){
        System.out.println("After");
        // Her setten sonra calisir
    }

    @Test
    public void test01(){
        System.out.println("Test 01");
    }

    @Test
    public void test02(){
        System.out.println("Test 02");
    }

    @Test
    public void test03(){
        System.out.println("Test 03");
    }

}
