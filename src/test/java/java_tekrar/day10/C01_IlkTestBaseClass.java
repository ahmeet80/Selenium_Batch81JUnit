package java_tekrar.day10;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {

    @Test
    public void test(){
        driver.get("https://amazon.com");
    }
}
