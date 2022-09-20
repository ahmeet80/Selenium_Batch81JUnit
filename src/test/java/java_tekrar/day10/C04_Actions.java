package java_tekrar.day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
   /*
    Yeni bir class olusturalim: MouseActions1
    https://the-internet.herokuapp.com/context_menu sitesine gidelim  3- Cizili alan uzerinde sag click yapalim
    Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
    Tamam diyerek alert’i kapatalim
    Elemental Selenium linkine tiklayalim
    Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
      */
    @Test
    public void test1() throws InterruptedException {
        //Yeni bir class olusturalim: MouseActions1 https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili olan alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform(); // action'da contextClick() ile sag click yapiyoruz (perform dugmeye bas demek)
        Thread.sleep(2000);



        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText()); // cikan Allert'i assert ile kontrol ettik

        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        driver.navigate().refresh(); // ekranda sag click kalmasin diye !!!!!!!! ama ise yaramiyor

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles()); // bu konuya egilmek lazım
        driver.switchTo().window(windowList.get(0));

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());

    }
}
