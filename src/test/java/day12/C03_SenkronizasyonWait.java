package day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;
    //not
//implicitly wait testten once calsitirilir ve calistirilan testin tamamina etki eder
//explicitly wait ise once obje olarak olusturulur sonra
// sadece kullanildigi yerde ve belirlenen sarta gore calisir class yada test in tamamina uygulanmaz

public class C03_SenkronizasyonWait extends TestBaseBeforeAfter {
    @Test
    public void implicitlyWaittest1() {
        // 1. Bir class olusturun : WaitTest
        // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //   Iki metod icin de asagidaki adimlari test edin.
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        WebElement addRemoveButon = driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
        addRemoveButon.click();
        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebElement message = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(message.isDisplayed());
        // 6. Add buttonuna basin
        addRemoveButon.click();
        // 7. It's back mesajinin gorundugunu test edin

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed()); // message de olmasi lazim ama olmadi ilginc !!!


    }

    @Test
    public void explicitWaittest2() {

                /*
                imlicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
                max belirttiğimiz süre altında bütün web elementler için bekler
                  */

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        WebElement addRemoveButon = driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
        addRemoveButon.click();
        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String expectedText = "It's gone!";
        String actualText = itsGoneWE.getText();
        Assert.assertEquals(expectedText,actualText);

         /*
        explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */

        // 6. Add buttonuna basin
        WebElement addButtonWE = driver.findElement(By.xpath("//button[text()='Add']"));
        addButtonWE.click();
        WebElement itsBackWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        // 7. It's back mesajinin gorundugunu test edin
        String actualText2 = itsBackWE.getText();
        String expectedText2 = "It's back!";
        Assert.assertEquals(expectedText2, actualText2);




    }
}
