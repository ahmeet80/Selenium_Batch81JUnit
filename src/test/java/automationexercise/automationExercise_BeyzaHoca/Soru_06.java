package automationExercise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Soru_06 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//*[@id='slider']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println("Ana sayfa testi başarılı");
        } else System.out.println("Ana sayfa testi başarısız");

        //4. 'Bize Ulaşın' düğmesine tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();

        //5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
        if (driver.findElement(By.xpath("//*[text()='Get In Touch']")).isDisplayed()) {
            System.out.println("Get in touch yazısı PASSED");
        } else System.out.println("Get in touch yazısı FAILED");

        //6. Adı, e-posta adresini, konuyu ve mesajı girin
        driver.findElement(By.xpath("//*[@data-qa='name']")).sendKeys("Tarık");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='email']")).sendKeys("tariktechpro@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='subject']")).sendKeys("Account Delete");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='message']")).sendKeys("Delete my account please");

        //7. Dosya yükle
        Thread.sleep(1000);
        WebElement uploadFile = driver.findElement(By.xpath("//*[@type='file']"));
        uploadFile.sendKeys("C:\\Users\\Tarik\\Desktop\\hesapsil.png");


        /*
        38. satıra kendi bilgisayarınızdan yükleyeceğiniz dosyanın yolunu girin. şu haliyle hata verir
        çünkü orada sendKeys içerisindeki parametre benim bilgisayarımdaki bir fotoğrafa ait.
         */

        //8. 'Gönder' düğmesini tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();

        //9. Tamam düğmesine tıklayın
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        /*
        internetten öğrendiğime göre Alert, sayfaya çıkan uyarı mesajlarıyla ilgili işlem yapmamıza olanak veriyormuş.
        accept() methodu da çıkan uyarıyı kabul ediyormuş.
         */

        //10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        if (driver.findElement(By.xpath("//*[@class='status alert alert-success']")).isDisplayed()) {
            System.out.println("Başarı mesajı doğrulama testi PASSED");
        } else System.out.println("Başarı mesajı doğrulama testi FAILED");

        //11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='fa fa-home']")).click();
        WebElement donulenAnaSayfa = driver.findElement(By.xpath("//*[@id='header']"));
        if (donulenAnaSayfa.isDisplayed()) {
            System.out.println("Ana sayfaya dönme testi başarılı");
        } else System.out.println("Ana sayfaya dönme testi başarısız");
    }
}
