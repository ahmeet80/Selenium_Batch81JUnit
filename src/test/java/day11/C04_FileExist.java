package day11;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExist {
    @Test
    public void test1() {

        System.out.println(System.getProperty("user.dir")); // C:\Users\Zehra\IdeaProjects\Batch81JUnit
        // Şu an içinde bulundugumuz yolu gosterir
        System.out.println(System.getProperty("user.home")); // C:\Users\Zehra
    /*
        String farkliBolum = System.getProperty("user.home");
        // C:\Users\Zehra\Desktop\text.txt --> masaustundeki dosya yolu
        String ortakBolum = "\\Desktop\\text.txt";

        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaustundeki dosya yolunu gosterir

         System.out.println(masaUstuDosyaYolu); // C:\Users\Zehra\Desktop\text.txt
        System.out.println(Paths.get(dosyayYolu));
        Assert.assertTrue(Files.exists(Paths.get(dosyayYolu)));
    */

        String dosyayYolu = "C:\\Users\\Zehra\\Desktop\\text.txt";
        System.out.println(Paths.get(dosyayYolu));
        Assert.assertTrue(Files.exists(Paths.get(dosyayYolu))); // dosya orada mı diye kontrol ediyor (dosya var mı yok mu bak da gel!)

        /*

        Bir Web sitesinden indirdigimiz yada windows icinde
        olusturdugumuz dosyanin indigini yada orda oldugunu
        test edebilmek icin o dosyanin uzerine shift tusuna
        basili olarak sag click yapip dosyanin yolunu kopyalayıp
        bir String degiskene atariz ve dosyayi dogrulamak icin
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); methodunu kullaniriz.

         */
    }
}
