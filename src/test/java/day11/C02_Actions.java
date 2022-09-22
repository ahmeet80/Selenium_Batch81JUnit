package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // 1- https://www.facebook.com adresine gidelim  2- Yeni hesap olustur butonuna basalim
        driver.get("https://www.facebook.com");
        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // 3-Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-']"));
        isim.sendKeys("Ahmet");
        actions.sendKeys(Keys.TAB).
                sendKeys("ASLAN").
                sendKeys(Keys.TAB).
                sendKeys("ahmetttt@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("ahmetttt@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("040303047").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).
                sendKeys("Tem").sendKeys(Keys.TAB).
                sendKeys("1985").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

                //sendKeys("1985").sendKeys(Keys.TAB).



    }
}
