package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class day12_odev2 extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //Ödev 2
        //"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //"Our Products" butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement our = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Our Products']")));
        //WebElement our=driver.findElement(By.xpath("//*[@href='products.html']"));
        our.click();
        //"Cameras product"i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();

        //Popup mesajini yazdirin
        WebElement popUpUyariMesaji = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal-body']")));

        //String popUpUyariMesajiStr =popUpUyariMesaji.getText();
        System.out.println(popUpUyariMesaji.getText());
        //"close" butonuna basin
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[2]")).click();
        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();
        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedurl="http://webdriveruniversity.com/index.html";
        String actualurl=driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,actualurl);
    }
}
