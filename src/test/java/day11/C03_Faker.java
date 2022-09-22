package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        /*
            Faker class'ini kullanma amacimiz form doldurmamiz gereken web siteşerde defalaca kendi ureecegimiz veriler yerine
        bizim icin random veriler uretir ve islerimizi kolaylastirir
        Faker classini kullanmak icin mvnrepository.com adresinden java-faker kutuphanesimi aratir ve en cok kullanilani aratir ve
        pom.xml dozyamiza ekleriz. ve faker class'indan bir oje olusturup;
        email icin faker.internet() metodunu kullanarak emailAddress() methodunu seceriz.
        isim ve soyisimlerr icin faker.name() methodu ile firstname() ve lastname() methodunu kullaniriz
         */
        WebElement isim = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-']"));
        Actions actions = new Actions(driver);
        actions.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).

                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).

                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).
                sendKeys("Tem").sendKeys(Keys.TAB).
                sendKeys("1985").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Kaydol butonuna basın
        //Sayfayi kapatin
    }
}
