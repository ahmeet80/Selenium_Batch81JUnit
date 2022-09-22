package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class day11_Odev01 extends TestBaseBeforeAfter {
    //Ödev 1
     /*
        Yeni Class olusturun ActionsClassHomeWork
        1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
        Link 1" e tiklayin
        Popup mesajini yazdirin
        Popup'i tamam diyerek kapatin
        "Click and hold" kutusuna basili tutun
        7-"Click and hold" kutusunda cikan yaziyi yazdirin
        8- "Double click me" butonunu cift tiklayin
    */
    @Test
    public void test1() throws InterruptedException {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        Actions action = new Actions(driver);
        WebElement hoverOver =driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverOver).
                sendKeys(Keys.ARROW_DOWN).//aşağı ok(arrow)
                click(hoverOver).perform();

        //Link 1" e tiklayin
//        WebElement tikla =driver.findElement(By.xpath("(//*[text()='Link 1'])[1]"));
//        tikla.click();
        Thread.sleep(3000);
        //Popup mesajini yazdirin
        System.out.println("popup mesaji = " + driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //"Click and hold" kutusuna basili tutun
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement basVeTut = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(basVeTut).perform();

        //7-"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(basVeTut.getText());

        //8- "Double click me" butonunu cift tiklayin
        WebElement ciftTikla = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(ciftTikla).perform();


    }
}

