package day11;

import com.google.j2objc.annotations.Weak;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class day11_Odev02 extends TestBaseBeforeAfter {
    //Ödev 2
    /*

    1-) https://html.com/tags/iframe/ sayfasina gidelim
    2-) video'yu gorecek kadar asagi inin
    3-) videoyu izlemek icin Play tusuna basin, videoyu calistirdiginizi test edin
            */
    @Test
    public void test01() {
        //1-) https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //2-) video'yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        //3-) videoyu izlemek icin Play tusuna basin, videoyu calistirdiginizi test edin
        //List<WebElement> videoIframe = driver.findElements(By.xpath("//iframe"));
        //driver.switchTo().frame(videoIframe.get(0));
        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        WebElement videoButon = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        videoButon.click();
        Assert.assertFalse("Video calismadi!!!", videoButon.isDisplayed());

    }
}
