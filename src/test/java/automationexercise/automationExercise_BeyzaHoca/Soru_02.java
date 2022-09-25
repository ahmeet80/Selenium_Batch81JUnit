package automationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Soru_02 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//section[@id='slider']"));
        if (anaSayfa.isDisplayed()){
            System.out.println("Ana Sayfa testi PASSED");
        } else System.out.println("Ana Sayfa testi FAILED");

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Thread.sleep(1000);
        if (driver.findElement(By.xpath("//*[@class='login-form']")).isDisplayed()){
            System.out.println("Hesabınızla giriş yapın testi PASSED");
        } else System.out.println("Hesabınızla giriş yapın testi FAILED");

        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("tariktechpro@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("12345!");

        //7. 'Giriş' düğmesini tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        if (driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed()) {
            System.out.println("Kullanıcı adıyla oturum açıldı testi PASSED");
        } else System.out.println("Kullanıcı adıyla oturum açıldı testi FAILED");

        //9. 'Hesabı Sil' düğmesini tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();
        Thread.sleep(1000);

        //10. 'HESAP SİLİNDİ!' görünür
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
    }
}
