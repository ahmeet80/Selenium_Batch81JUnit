package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_readExcel {
    @Test
    public void readExcelTest1() throws IOException {

        // Belirtilen satirNo ve StunNo degerlerini parametre olarak alip o cell'deki data'yi konsola yazdiralim


        int satir = 12; // 11. index
        int stun = 2; // 1. index

        String dosyaYolu= "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String actualData = workbook.
                getSheet("Sayfa1").
                getRow(satir-1).
                getCell(stun-1).
                toString();
        // Index 0'dan basladigindan bizden istenen veriye ulasabilmek icin satir ve stun'un 1 eksigini aliriz
        System.out.println(actualData);

        // Sonucun konsolda yazilanla ayni oldugunu dogrulayin

        String konsoldaYazan = "Baku";
        Assert.assertEquals(konsoldaYazan,actualData);


    }
}
