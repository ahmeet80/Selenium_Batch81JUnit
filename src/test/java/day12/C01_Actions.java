package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // https://automationexecises.com sitesini gidelim
        driver.get("https://www.automationexercise.com/");
        // Product bolumune girelim
        driver.findElement(By.cssSelector("a[href='/products']")).click();
        // ilk urune tıklayalaım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
    }
}
