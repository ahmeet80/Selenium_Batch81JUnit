package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTable extends TestBaseBeforeAfter {
    @Test
    public void tes1() {
        //Bir class oluşturun : C02_WebTables

        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //login( ) metodun oluşturun ve oturum açın.
        login();
        //table( ) metodu oluşturun
        table();


    }

    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        /*
        Tabloda <table> tagı altında tablonun baslıgını gosteren <thead> tagı bulunur.
        Eger baslikda satir(row) varsa <thead> tagı altinda <tr> (satır-row) tagı vardır.
        Ve baslıkdaki sutunlara yani hucrelere(cell) de <th> tagı ile ulasilir.
        Baslıgın tablodaki verilere <tbody> tagı ile altındaki satırlara(row) <tr> tagı ile sutunlara yani
        hucrelere <td> tagı ile ulasilir.
         */
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th")); // anlamadım
        System.out.println("Sutun Sayisi = "+sutunSayisi.size());
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thread//tr")); // anlamadım
        System.out.println("Basliklar : " + basliklar.getText());
        WebElement body = driver.findElement(By.xpath("//tbody")); // anlamadım
        System.out.println("Tum Body : " + body.getText());
        /*for (WebElement w:sutunSayisi ) {
            System.out.print(w.getText()+ " ");
        }*/
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr)")); // anlamadım
        System.out.println("Tablodaki Satir sayisi :" + satirList.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t-> System.out.println(t.getText()));
        //4.satirdaki(row) elementleri konsolda yazdırın.

    }

    private void login() {
        //Username : manager
        //Password : Manager1!
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin ");
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("(//*[@class='form-control form-control-solid placeholder-no-fix required'])[1]"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
