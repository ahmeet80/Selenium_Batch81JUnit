package automationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Soru_03 {
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
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        if (driver.findElement(By.xpath("//*[@class='login-form']")).isDisplayed()){
            System.out.println("Hesabınızla giriş yapın testi PASSED");
        } else System.out.println("Hesabınızla giriş yapın testi FAILED");

        //6. Yanlış e-posta adresi ve şifre girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("rariktechpro@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("1234!");

        /*
        26. veya 28. satırların herhangi birinde yanlış bilgi girseniz de olur ben her ikisine de yanlış girdim.
         */

        //7. 'Giriş' düğmesini tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        //8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        if (driver.findElement(By.xpath("//*[@style='color: red;']")).isDisplayed()) {
            System.out.println("Hata mesajı PASSED");
        } else System.out.println("Hata mesajı FAILED");
    }
}
