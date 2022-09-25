package automationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Soru_01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //1.  Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3.  Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//section[@id='slider']"));
        if (anaSayfa.isDisplayed()){
            System.out.println("Ana Sayfa testi PASSED");
        } else System.out.println("Ana Sayfa testi FAILED");

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        if (driver.findElement(By.className("signup-form")).isDisplayed()) {
            System.out.println("Yeni Kullanıcı Kaydı testi PASSED");
        } else System.out.println("Yeni Kullanıcı Kaydı testi FAILED");
        //6. Adı ve e-posta adresini girin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Tarık");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("tariktechpro@gmail.com");

        /*
        30. satıra kendi uydurduğunuz bir e-posta adresini girin. aksi halde "bu e-posta zaten var" hatası verir.
        girilen e-postalar sonradan silinemiyor ya da ben beceremedim.
         */

        //7. 'Kaydol' düğmesini tıklayın
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        if (driver.findElement(By.className("login-form")).isDisplayed()){
            System.out.println("Hesap Bilgilerini Girin testi PASSED");
        } else System.out.println("Hesap Bilgilerini Girin testi FAILED");

        //9.  Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='id_gender1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='days']")).sendKeys("25");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='months']")).sendKeys("April");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='years']")).sendKeys("2000");

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='optin']")).click();

        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//*[@data-qa='first_name']")).sendKeys("Tarık");
        driver.findElement(By.xpath("//*[@data-qa='last_name']")).sendKeys("KILIÇKAYA");
        driver.findElement(By.xpath("//*[@data-qa='address']")).sendKeys("Los Angeles");
        driver.findElement(By.xpath("//*[@data-qa='country']")).sendKeys("Australia");
        driver.findElement(By.xpath("//*[@data-qa='state']")).sendKeys("California");
        driver.findElement(By.xpath("//*[@data-qa='city']")).sendKeys("Los Angeles");
        driver.findElement(By.xpath("//*[@data-qa='zipcode']")).sendKeys("90001");
        driver.findElement(By.xpath("//*[@data-qa='mobile_number']")).sendKeys("123456789");

        //13. 'Hesap Oluştur düğmesini' tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();

        //14. 'HESAP OLUŞTURULDU!' görünür
        if (driver.findElement(By.xpath("//*[@data-qa='account-created']")).isDisplayed()) {
            System.out.println("Hesap Oluşturuldu testi PASSED");
        } else System.out.println("Hesap Oluşturuldu testi FAILED");
        //15. 'Devam' düğmesini tıklayın

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        if (driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed()) {
            System.out.println("Kullanıcı adıyla oturum açıldı testi PASSED");
        } else System.out.println("Kullanıcı adıyla oturum açıldı testi FAILED");

        //17. 'Hesabı Sil' düğmesini tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();

        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın

        /*
        dediğim gibi en son hesap silme kısmı çıkmadığı için 18. adımı yapamadım.
         */
    }
}
