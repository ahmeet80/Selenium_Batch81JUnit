package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test(){
        // 1 Amazon sayfasina gidelim
        driver.get("https://amazon.com");
        // 2 Account menusunden create a list linkine tiklayalim
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions = new Actions(driver); // Action mause ile ilgili islemleri yapmak icin kullanılıyor zannımca
        actions.moveToElement(accountList).perform(); // mause accountList üzerine gidip bekliyor
        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'ı fırlatır
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();




    }

}
