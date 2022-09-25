package automationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Soru_04 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        if (driver.findElement(By.xpath("//*[@id='slider']")).isDisplayed()) {
            System.out.println("Ana sayfa testi PASSED");
        } else System.out.println("Ana sayfa testi FAILED");

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        if (driver.findElement(By.className("login-form")).isDisplayed()) {
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

        //9. 'Çıkış' düğmesini tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //10. Kullanıcının giriş sayfasına yönlendirildiğini doğrulayın
        WebElement loginButonu = driver.findElement(By.xpath("//*[@data-qa='login-button']"));
        WebElement signupButonu = driver.findElement(By.xpath("//*[@data-qa='signup-button']"));
        if (loginButonu.isDisplayed() && signupButonu.isDisplayed()) {
            System.out.println("Kullanıcı giriş ekranına yönlendirme testi PASSED");
        } else System.out.println("Kullanıcı giriş ekranına yönlendirme testi FAILED");


        /*
        10. adımda kullanıcın giriş sayfasına yönlendirildiğini doğrulamak için giriş sayfasında bulunan
        login ve signup butonlarını locate edip bunların görünüp görünmediğini sorguladım. eğer her ikisi de görünüyorsa
        ekranda kullanıcı giriş sayfası açık demektir.
         */
    }
}
