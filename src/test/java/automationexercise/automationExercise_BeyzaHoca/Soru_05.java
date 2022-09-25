package automationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Soru_05 {

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

        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        WebElement newUserSingupYazisi = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (newUserSingupYazisi.isDisplayed()) {
            System.out.println("Yeni kullanıcı kaydı yazısı testi PASSED");
        } else System.out.println("Yeni kullanıcı kaydı yazısı testi FAILED");
        //6. Adı ve kayıtlı e-posta adresini girin
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Tarık");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("tariktechpro@gmail.com");

        /*
        28. satırda, ilk classta kaydolurken kendi uydurduğunuz e-postayı girin ki "bu e-posta zaten var" uyarısı versin.
         */

        //7. 'Kaydol' düğmesini tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        //8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
        WebElement alreadyExistYazisi = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        if (alreadyExistYazisi.isDisplayed()) {
            System.out.println("Already is exist yazısı PASSED");
        } else System.out.println("Already is exist FAILED");
    }
}
